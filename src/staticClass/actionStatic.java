package staticClass;

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
import org.sembysem.modeldescription.PropertyModel;

public class actionStatic extends Observable {
	public static ArrayList<ActionModel> _owlactionList = new ArrayList<ActionModel>();
	@SuppressWarnings("rawtypes")
	public static ArrayList<OWLProperty> _owlPropertyList = new ArrayList<OWLProperty>();
	public static ArrayList<PropertyModel> _owlPropertyConcepttList = new ArrayList<PropertyModel>();
	public static ArrayList<ConceptModel> _owlMicroConceptList = new ArrayList<ConceptModel>();
	public static ArrayList<OWLClass> _owlClassList = new ArrayList<OWLClass>();
	public static OWLOntology MyOntologie;
	public static OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
	public static OWLNamedIndividual owlNamedIndividual;
}
