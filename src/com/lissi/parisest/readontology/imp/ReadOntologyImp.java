package com.lissi.parisest.readontology.imp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.lissi.extension.owl.smc.editor.ActivatorSmc;
import org.sembysem.modeldescription.ActionModel;
import org.sembysem.modeldescription.ConceptModel;
import org.sembysem.modeldescription.ConceptRange;
import org.sembysem.modeldescription.ElementModel;
import org.sembysem.modeldescription.EnumerationModel;
import org.sembysem.modeldescription.InstanceModel;
import org.sembysem.modeldescription.LiteralRange;
import org.sembysem.modeldescription.ModelDescription;
import org.sembysem.modeldescription.ParameterDomainModel;
import org.sembysem.modeldescription.ParameterModel;
import org.sembysem.modeldescription.PropertyModel;
import org.sembysem.modeldescription.Range;
import org.sembysem.persistence.ISemanticModelLoader;
import org.sembysem.persistence.SemanticModelLoaderFactory;

import com.lissi.parisest.readontology.MCAction;
import com.lissi.parisest.readontology.MCProperty;
import com.lissi.parisest.readontology.MCType;
import com.lissi.parisest.readontology.MicroConcept;
import com.lissi.parisest.readontology.OntologyType;
import com.lissi.parisest.readontology.ReadOntology;
import com.lissi.parisest.readontology.StaticInstance;

public class ReadOntologyImp implements ReadOntology {

	private Map<String, MicroConcept> microConceptMap;
	private Map<String, MCAction> mcActionMap;

	private Map<String, StaticInstance> staticInstanceMap;
	private Map<String, MCProperty> propertyMap = null;
	private ModelDescription model = null;
	private byte[] byteArray = "no ontology source available".getBytes();


	public ReadOntologyImp()
	{

		microConceptMap = new HashMap<String, MicroConcept>();
		staticInstanceMap = new HashMap<String, StaticInstance>();
		propertyMap = new HashMap<String, MCProperty>();
		setMcActionMap(new HashMap<String, MCAction>());
	}


	@Override
	public Map<String, MicroConcept> getMicroConceptMap()
	{

		return microConceptMap;
	}


	@Override
	public Map<String, StaticInstance> getStaticInstanceMap()
	{

		return staticInstanceMap;
	}


	@Override
	public void loadOntology(String filePath) throws Exception
	{

		if (filePath.toUpperCase().endsWith(".SMC"))
		{
			loadOntology(new FileInputStream(filePath), OntologyType.SMC);
		} else if (filePath.toUpperCase().endsWith(".OWL"))
		{
			loadOntology(new FileInputStream(filePath), OntologyType.OWL);
		} else
		{
			throw new Exception("Invalid ontology file extension, should be .smc or .owl");
		}
	}


	@Override
	public void loadOntology(InputStream input, OntologyType ontologyType) throws Exception
	{

		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		StringBuffer buffer = new StringBuffer();
		String line = reader.readLine();
		while (line != null)
		{
			buffer.append(line + "\n");
			line = reader.readLine();
		}
		byteArray = buffer.toString().getBytes();

		loadOntology(loadModelFile(new ByteArrayInputStream(byteArray), ontologyType));
		ActivatorSmc.model = loadModelFile(new ByteArrayInputStream(byteArray), ontologyType);

	}


	@Override
	public void loadOntology(ModelDescription inputModel) throws Exception
	{

		this.model = inputModel;

		Iterable<ElementModel> elements = model.getElements();

		// Loading micro concepts
		for (ElementModel elem : elements)
		{
			if (elem instanceof ConceptModel || elem instanceof EnumerationModel)
			{
				System.out.println(elem.getUri());
				/*
				 * javadoc of Thales API java.lang.Iterable<java.lang.String>
				 * getParentConcepts() Gets the list of concepts that are parent
				 * of the current concept.
				 */

				// check if concept has been loaded yet
				String microConceptFullName = elem.getUri();
				String conceptName = microConceptFullName.substring(microConceptFullName.lastIndexOf("/") + 1);

				MicroConcept microConcept = microConceptMap.get(conceptName.replaceAll("^.*[/#]", ""));
				if (microConcept == null)
				{
					microConcept = new MicroConceptImp();
					microConcept.setOntologyClassName(microConceptFullName);
				}
				microConcept.setName(conceptName.replaceAll("^.*[/#]", "").trim());

				/* Remplir la liste de Parents */

				if (elem instanceof ConceptModel)
				{
					ConceptModel conceptModel = (ConceptModel) elem;
					System.out.println(elem.getUri());
					Iterable<String> iterator = conceptModel.getParentConcepts();
					for (String s : iterator)
					{
						MicroConcept mConcept = microConceptMap.get(s.replaceAll("^.*[/#]", ""));
						if (mConcept == null)
						{
							mConcept = new MicroConceptImp();
							mConcept.setOntologyClassName(microConceptFullName);
						}
						mConcept.setName(s.replaceAll("^.*[/#]", "").trim());
						((MicroConceptImp) microConcept).addMicroConcept(mConcept);
						mConcept.getChildrenConcept().add(microConcept);
						microConceptMap.put(mConcept.getName(), mConcept);

					}
				}
				microConceptMap.put(conceptName.replaceAll("^.*[/#]", ""), microConcept);
			}// end if
		}// end for

		// loading static instances
		for (ElementModel elem : elements)
		{
			if (elem instanceof InstanceModel)
			{
				System.out.println(elem.getUri());
				InstanceModel instance = (InstanceModel) elem;
				String type = instance.getTypeUri().substring(elem.getUri().lastIndexOf("/") + 1);
				String instanceTypeName = elem.getUri().substring(elem.getUri().lastIndexOf("/") + 1);
				MicroConcept mcImp = microConceptMap.get(type.replaceAll("^.*[/#]", ""));
				StaticInstanceImp staticInstanceImp = new StaticInstanceImp();
				staticInstanceImp.setType(mcImp);
				staticInstanceImp.setName(instanceTypeName.replaceAll("^.*[/#]", ""));
				staticInstanceMap.put(staticInstanceImp.getName(), staticInstanceImp);
			}// end if

		}// end for

		for (ElementModel elem : elements)
		{
			if (elem instanceof ActionModel)
			{
				System.out.println(elem.getUri());
				ActionModel actionModel = (ActionModel) elem;
				MCAction mcAction = new MCAction();

				// add this action as action of concept

				mcAction.setOntologyActionName(elem.getUri());

				Set<String> domains = new HashSet<String>(actionModel.getDomains());
				domains = buildCompleteDomainHierachy(domains);

				for (String domain : domains)
				{
					MicroConcept microConcept = microConceptMap.get(domain.replaceAll("^.*[#/]", ""));
					microConcept.getActions().add(mcAction);
				}

				mcAction.setName(actionModel.getUri().replaceAll("^.*[#/]", ""));
				mcActionMap.put(mcAction.getName(), mcAction);

			}
		}

		// add properties
		for (ElementModel elem : elements)
		{

			if (elem instanceof PropertyModel || elem instanceof ParameterModel)
			{
				System.out.println(elem.getUri());
				String elementType = null;
				int elementMinCar;
				int elementMaxCar;
				boolean multiple = false;
				boolean order = false;
				Range elementRange;
				if (elem instanceof PropertyModel)
				{
					PropertyModel property = (PropertyModel) elem;
					elementType = property.getPropertyType().toString();
					elementMinCar = property.getMinCardinality();
					elementMaxCar = property.getMaxCardinality();
					elementRange = property.getRange();

				} else
				{
					ParameterModel param = (ParameterModel) elem;
					elementType = param.getPropertyType().toString();
					elementMinCar = param.getMinCardinality();
					elementMaxCar = param.getMaxCardinality();
					elementRange = param.getRange();
				}

				String elementName = elem.getUri().substring(elem.getUri().lastIndexOf("/") + 1);

				if (!elementName.replaceAll("^.*[/#]", "").matches("^[a-z].*"))
				{
					if (elem instanceof PropertyModel)
					{
						System.err.println("Warning property " + elementName.replaceAll("^.*[/#]", "") + " must start with a capital letter");
					} else
					{
						System.err.println("Warning action parameter " + elementName.replaceAll("^.*[/#]", "") + " must start with a capital letter");
					}
				}

				MCType mcRangeType = null;

				// getting the range type
				String propertyTypeName;
				if (elementRange instanceof ConceptRange)
				{
					ConceptRange range = (ConceptRange) elementRange;
					propertyTypeName = range.getConcept().replaceAll("^.*/", "");
					mcRangeType = new MicroConceptImp();
					((MicroConceptImp) mcRangeType).setOntologyClassName(range.getConcept());
				} else
				{
					LiteralRange range = (LiteralRange) elementRange;
					propertyTypeName = range.getLiteralType().name();
					switch (range.getLiteralType()) {
					case Boolean:
						mcRangeType = new BooleanType();
						break;
					case Time:
						mcRangeType = new TimeType();
						break;
					case DateTime:
						mcRangeType = new DateTimeType();
						break;
					case Date:
						mcRangeType = new DateType();
						break;
					case String:
						mcRangeType = new StringType();
						break;
					case Decimal:
						mcRangeType = new DecimalType();
						break;
					case Duration:
						mcRangeType = new DurationType();
						break;
					case Integer:
						mcRangeType = new IntegerType();
						break;
					}
				}

				if (elementType.compareTo("List") == 0)
				{
					multiple = true;
					order = true;
					mcRangeType.setName(propertyTypeName.replaceAll("^.*[/#]", "").trim());

					MCType saveTypeTemp = mcRangeType;
					mcRangeType = new ListType();
					mcRangeType.setName("List<" + saveTypeTemp.getName().trim() + ">");
					((ListType) mcRangeType).setInnerType(saveTypeTemp);
					// mcType.setMultiple(true);

				} else if (elementType.compareTo("Set") == 0)
				{

					order = false;
					multiple = true;
					mcRangeType.setName(propertyTypeName.replaceAll("^.*[/#]", "").trim());
					MCType saveTypeTemp = mcRangeType;

					mcRangeType = new ListType();
					mcRangeType.setName("List<" + saveTypeTemp.getName().trim() + ">");
					((ListType) mcRangeType).setInnerType(saveTypeTemp);
				} else if (elementType.compareTo("Functional") == 0)
				{
					if (elementRange instanceof LiteralRange)
					{
						LiteralRange lr = (LiteralRange) elementRange;
						String type = lr.getLiteralType().toString();
						mcRangeType.setName(type.replaceAll("^.*[/#]", "").trim());
						mcRangeType.setPrimitive(true);
					} else if (elementRange instanceof ConceptRange)
					{
						ConceptRange cr = (ConceptRange) elementRange;
						String type = cr.getConcept().replaceAll("^.*[/#]", "").trim();
						mcRangeType = microConceptMap.get(type.replaceAll("^.*[/#]", "").trim());
					}
				}

				// add property to Property Map

				if (elem instanceof PropertyModel)
				{
					System.out.println(elem.getUri());
					MCPropertyImp microPropertyImp = new MCPropertyImp();
					microPropertyImp.setName(elementName.replaceAll("^.*[/#]", ""));
					microPropertyImp.setMinCardinality(elementMinCar);
					microPropertyImp.setMaxCardinality(elementMaxCar);
					microPropertyImp.setType(mcRangeType);
					microPropertyImp.setMultiple(multiple);
					microPropertyImp.setOrdered(order);
					propertyMap.put(elementName.replaceAll("^.*[/#]", ""), microPropertyImp);

					Set<String> fullDomainsSet = getAllDomains((PropertyModel) elem);
					for (String s : fullDomainsSet)
					{
						String domaine = s.replaceAll("^.*[/#]", "");
						if (microConceptMap.containsKey(domaine))
						{
							microConceptMap.get(domaine).getPropertyMap().put(elementName.replaceAll("^.*[/#]", ""), microPropertyImp);
						}
					}

				} else
				{
					MCParameterImpl paramImp = new MCParameterImpl();
					paramImp.setName(elementName.replaceAll("^.*[/#]", ""));
					paramImp.setMinCardinality(elementMinCar);
					paramImp.setMaxCardinality(elementMaxCar);
					paramImp.setType(mcRangeType);
					paramImp.setMultiple(multiple);
					paramImp.setOrdred(order);
					ParameterModel param = (ParameterModel) elem;
					HashSet<String> domains = new HashSet<String>();
					for (ParameterDomainModel parameterDomain : param.getDomains())
					{
						domains.add(parameterDomain.getAction());
					}
					for (String s : domains)
					{
						String domaine = s.replaceAll("^.*[/#]", "");
						if (mcActionMap.containsKey(domaine))
						{
							mcActionMap.get(domaine).getParamMap().put(elementName.replaceAll("^.*[/#]", ""), paramImp);
						}
					}
				}

			}
		}

		for (ElementModel elem : elements)
		{
			if (elem instanceof PropertyModel)
			{
				System.out.println(elem.getUri());
				PropertyModel property = (PropertyModel) elem;
				String propertyName = elem.getUri().replaceAll("^.*[/#]", "");
				// parcourir les propriétés de tous les micro-concepts
				for (MicroConcept mc : microConceptMap.values())
				{
					// localiser la proprieté
					if (mc.getPropertyMap().keySet().contains(propertyName))
					{

						// récupérer ces parents
						for (String str : property.getParentProperties())
						{

							// ajouter les parents de type MCProperty stocké
							// dans la map propertyMap
							// à la proriété localisée
							MCProperty mcp = propertyMap.get(str);
							mc.getPropertyMap().get(str).getSuperProperties().add(mcp);
						}
					}
				}
			}
		}

	}


	public static void main(String[] args) throws Exception
	{

		String fileName = "./resources/AssetTracking.smc";
		ReadOntologyImp ro = new ReadOntologyImp();
		ro.loadOntology(fileName);

	}


	private ModelDescription loadModelFile(InputStream in, OntologyType ontologyType)
	{

		ISemanticModelLoader modelLoader = SemanticModelLoaderFactory.createModelLoader();
		// Load from file
		ModelDescription model = null;

		try
		{
			switch (ontologyType) {
			case OWL:
				model = modelLoader.loadOWLModel(in);

				break;
			case SMC:
				model = modelLoader.loadMicroConceptModel(in);

			}

		} catch (IOException ex)
		{
			ex.printStackTrace();
			System.exit(1);
		}
		return model;
	}


	@Override
	public String getOntologyText()
	{

		String line = null, myOntology = "";
		BufferedReader in;
		try
		{

			in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArray)));
			line = in.readLine();
			while (line != null)
			{
				// System.out.print(line);
				myOntology += line + "\n";
				line = in.readLine();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return myOntology;
	}


	private List<PropertyModel> getAllParentProperty(PropertyModel prop)
	{

		List<PropertyModel> list = new ArrayList<PropertyModel>();
		for (String superPropName : prop.getParentProperties())
		{
			PropertyModel superProp = (PropertyModel) model.getElement(superPropName);
			list.add(superProp);
			list.addAll(getAllParentProperty(superProp));
		}
		return list;
	}


	private Set<String> getAllDomains(PropertyModel prop)
	{

		/* - ------- listing all domains */
		// regular domains
		Set<String> domainSet = new HashSet<String>();
		for (String domain : prop.getDomains())
		{
			domainSet.add(domain);
		}

		// domains from inverse properties
		if (prop.getInverseProperty() != null)
		{
			PropertyModel inverse;
			inverse = (PropertyModel) model.getElement(prop.getInverseProperty());
			domainSet.add(((ConceptRange) inverse.getRange()).getConcept());
		}

		// domains from parent properties
		for (PropertyModel parent : getAllParentProperty(prop))
		{
			for (String domain : parent.getDomains())
			{
				domainSet.add(domain);
			}
			if (parent.getInverseProperty() != null)
			{
				PropertyModel inverse;
				inverse = (PropertyModel) model.getElement(parent

				.getInverseProperty());
				domainSet.add(((ConceptRange) inverse.getRange()).getConcept());
			}
		}

		return buildCompleteDomainHierachy(domainSet);

	}


	private Set<String> buildCompleteDomainHierachy(Set<String> domainSet)
	{

		Set<String> childrenDomain = new HashSet<String>();
		Set<String> returnDomain = new HashSet<String>(domainSet);

		for (String parent : domainSet)
		{
			System.out.println(parent.replaceAll("^.*[/#]", ""));
			/*
			 * for (MicroConcept children : microConceptMap.get(
			 * parent.replaceAll("^.*[/#]", "")).getChildrenConcept()) {
			 * childrenDomain.add(children.getName()); }
			 */
			returnDomain.addAll(childrenDomain);
			returnDomain.addAll(buildCompleteDomainHierachy(childrenDomain));
		}
		return returnDomain;
	}


	@Override
	public void setMcActionMap(Map<String, MCAction> mcActionMap)
	{

		this.mcActionMap = mcActionMap;
	}


	@Override
	public Map<String, MCAction> getMcActionMap()
	{

		return mcActionMap;
	}

}
