package org.lissi.extension.owl.smc.editor;

/*     */
/*     */import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.sembysem.modeldescription.ActionModel;
import org.sembysem.modeldescription.ConceptModel;
import org.sembysem.modeldescription.ElementModel;
import org.sembysem.modeldescription.InstanceModel;
import org.sembysem.modeldescription.ModelDescription;
import org.sembysem.modeldescription.OntologyModel;
import org.sembysem.modeldescription.ParameterModel;
import org.sembysem.modeldescription.PropertyModel;

/*     */
/*     */public class ModelDescriptionControllerSmc
/*     */{
	/*     */private ModelDescription model;


	/*     */
	/*     */public ModelDescriptionControllerSmc(ModelDescription model)
	/*     */
	{

		/* 17 */this.model = model;
		/*     */}


	/*     */
	/*     */public Iterable<ConceptModel> getConcepts()
	/*     */
	{

		/* 24 */List concepts = new ArrayList();
		/* 25 */Iterable concept = this.model.getElements();
		/* 26 */Iterator t = concept.iterator();
		/* 27 */List<ElementModel> elementModel = new ArrayList<ElementModel>();
		/* 28 */while (t.hasNext())
			/* 29 */elementModel.add((ElementModel) t.next());
		/* 30 */for (ElementModel element : elementModel)
		{
			/* 31 */if ((element instanceof ConceptModel))
			{
				/* 32 */concepts.add((ConceptModel) element);
				/*     */}
			/*     */}
		/* 35 */return concepts;
		/*     */}


	/*     */
	/*     */public Iterable<PropertyModel> getProperties()
	/*     */
	{

		/* 40 */List properties = new ArrayList();
		/* 41 */Iterable property = this.model.getElements();
		/* 42 */Iterator t = property.iterator();
		/* 43 */List<ElementModel> elementModel = new ArrayList<ElementModel>();
		/* 44 */while (t.hasNext())
		{
			/* 45 */elementModel.add((ElementModel) t.next());
			/*     */}
		/* 47 */for (ElementModel element : elementModel)
		{
			/* 48 */if ((element instanceof PropertyModel))
			{
				/* 49 */properties.add((PropertyModel) element);
				/*     */}
			/*     */}
		/* 52 */return properties;
		/*     */}


	/*     */
	/*     */public Iterable<ParameterModel> getParameters()
	/*     */
	{

		/* 57 */List parameters = new ArrayList();
		/* 58 */Iterable parameter = this.model.getElements();
		/* 59 */Iterator t = parameter.iterator();
		/* 60 */List<ElementModel> elementModel = new ArrayList<ElementModel>();
		/* 61 */while (t.hasNext())
		{
			/* 62 */elementModel.add((ElementModel) t.next());
			/*     */}
		/* 64 */for (ElementModel element : elementModel)
		{
			/* 65 */if ((element instanceof ParameterModel))
			{
				/* 66 */parameters.add((ParameterModel) element);
				/*     */}
			/*     */}
		/* 69 */return parameters;
		/*     */}


	/*     */
	/*     */public Iterable<ActionModel> getActions()
	/*     */
	{

		/* 74 */List actions = new ArrayList();
		/* 75 */Iterable action = this.model.getElements();
		/* 76 */Iterator t = action.iterator();
		/* 77 */List<ElementModel> elementModel = new ArrayList<ElementModel>();
		/* 78 */while (t.hasNext())
		{
			/* 79 */elementModel.add((ElementModel) t.next());
			/*     */}
		/* 81 */for (ElementModel element : elementModel)
		{
			/* 82 */if ((element instanceof ActionModel))
			{
				/* 83 */actions.add((ActionModel) element);
				/*     */}
			/*     */}
		/* 86 */return actions;
		/*     */}


	/*     */
	/*     */public Iterable<InstanceModel> getInstances()
	/*     */
	{

		/* 91 */List instances = new ArrayList();
		/* 92 */Iterable instance = this.model.getElements();
		/* 93 */Iterator t = instance.iterator();
		/* 94 */List<ElementModel> elementModel = new ArrayList<ElementModel>();
		/* 95 */while (t.hasNext())
		{
			/* 96 */elementModel.add((ElementModel) t.next());
			/*     */}
		/* 98 */for (ElementModel element : elementModel)
		{
			/* 99 */if ((element instanceof InstanceModel))
			{
				/* 100 */instances.add((InstanceModel) element);
				/*     */}
			/*     */}
		/* 103 */return instances;
		/*     */}


	/*     */
	/*     */public Iterable<OntologyModel> getOntologies()
	/*     */
	{

		/* 109 */List ontologies = new ArrayList();
		/* 110 */Iterable ontology = this.model.getElements();
		/* 111 */Iterator t = ontology.iterator();
		/* 112 */List<ElementModel> elementModel = new ArrayList<ElementModel>();
		/* 113 */while (t.hasNext())
		{
			/* 114 */elementModel.add((ElementModel) t.next());
			/*     */}
		/* 116 */for (ElementModel element : elementModel)
		{
			/* 117 */if ((element instanceof OntologyModel))
			{
				/* 118 */ontologies.add((OntologyModel) element);
				/*     */}
			/*     */}
		/* 121 */return ontologies;
		/*     */}
	/*     */
}

/*
 * Location: C:\Users\Riadh\Desktop\com.sembysem.editor.microconcepts_1.0.0.jar
 * Qualified Name:
 * org.sembysem.editor.microconcept.model.ModelDescriptionController JD-Core
 * Version: 0.6.2
 */
