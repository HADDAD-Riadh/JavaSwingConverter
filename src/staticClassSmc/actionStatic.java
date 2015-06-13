package staticClassSmc;

import java.util.ArrayList;
import java.util.Observable;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLProperty;
import org.sembysem.modeldescription.ActionModel;
import org.sembysem.modeldescription.ConceptModel;
import org.sembysem.modeldescription.InstanceModel;
import org.sembysem.modeldescription.PropertyModel;

import com.lissi.parisest.readontology.MicroConcept;
import com.lissi.parisest.readontology.StaticInstance;

public class actionStatic extends Observable {
	public static ArrayList<ActionModel> _owlactionList = new ArrayList<ActionModel>();
	@SuppressWarnings("rawtypes")
	public static ArrayList<OWLProperty> _owlPropertyList = new ArrayList<OWLProperty>();
	public static ArrayList<PropertyModel> _owlPropertyConcepttList = new ArrayList<PropertyModel>();
	public static ArrayList<ConceptModel> _owlMicroConceptList = new ArrayList<ConceptModel>();
	public static ArrayList<OWLClass> _owlClassList = new ArrayList<OWLClass>();
	public static ArrayList<MicroConcept> _SmcMicroConceptList = new ArrayList<MicroConcept>();
	public static OWLOntology MyOntologie;
	public static OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
	public static OWLNamedIndividual owlNamedIndividual;

	public static ArrayList<InstanceModel> _SmcStaticInstance = new ArrayList<InstanceModel>();
	public static ArrayList<ConceptModel> _SmcConcepts = new ArrayList<ConceptModel>();
	public static ArrayList<ActionModel> _SmcActions = new ArrayList<ActionModel>();
	public static ArrayList<PropertyModel> _SmcProperty = new ArrayList<PropertyModel>();
	public static ArrayList<StaticInstance> _StaticInstance = new ArrayList<StaticInstance>();

}
