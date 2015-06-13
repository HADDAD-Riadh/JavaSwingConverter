package org.lissi.extension.owl.smc;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Set;

import javax.swing.JFrame;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;

import staticClass.actionStatic;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;

public class GrapheInstanceRelations extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2764911804288120883L;


	public GrapheInstanceRelations(OWLObjectPropertyExpression property, Set<OWLNamedIndividual> values, OWLOntology ont)
	{

		super("Instance graph");

		final mxGraph graph = new mxGraph();
		graph.setAutoOrigin(true);
		graph.setConnectableEdges(false);
		graph.setCellsDisconnectable(false);
		graph.setCellsMovable(true);
		graph.setCellsBendable(false);
		// graph.setCellsLocked(true);
		graph.setCellsEditable(false);
		graph.setHtmlLabels(true);
		graph.setDisconnectOnMove(false);
		Hashtable<String, Object> style = new Hashtable<String, Object>();
		style.put(mxConstants.STYLE_FILLCOLOR, mxUtils.getHexColorString(Color.orange));
		style.put(mxConstants.STYLE_STROKEWIDTH, 2);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "#224400");
		style.put(mxConstants.STYLE_STROKECOLOR, mxUtils.getHexColorString(new Color(0, 0, 170)));
		style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_RECTANGLE);
		style.put(mxConstants.STYLE_PERIMETER, mxConstants.PERIMETER_RECTANGLE);

		Hashtable<String, Object> style3 = new Hashtable<String, Object>();
		style3.put(mxConstants.STYLE_FILLCOLOR, mxUtils.getHexColorString(new Color(120, 200, 219)));
		style3.put(mxConstants.STYLE_STROKEWIDTH, 2);
		style3.put(mxConstants.STYLE_OPACITY, 50);
		style3.put(mxConstants.STYLE_FONTCOLOR, "#214499");
		style3.put(mxConstants.STYLE_STROKECOLOR, mxUtils.getHexColorString(new Color(1, 70, 2)));
		style3.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_HEXAGON);
		style3.put(mxConstants.STYLE_PERIMETER, mxConstants.PERIMETER_HEXAGON);

		Hashtable<String, Object> style2 = new Hashtable<String, Object>();
		style2.put(mxConstants.STYLE_FILLCOLOR, mxUtils.getHexColorString(new Color(252, 242, 206)));
		style2.put(mxConstants.STYLE_STROKEWIDTH, 2);
		style2.put(mxConstants.STYLE_OPACITY, 50);
		style2.put(mxConstants.STYLE_FONTCOLOR, "#664400");
		style2.put(mxConstants.STYLE_STROKECOLOR, mxUtils.getHexColorString(new Color(0, 90, 0)));
		style2.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
		style2.put(mxConstants.STYLE_PERIMETER, mxConstants.PERIMETER_ELLIPSE);

		Object parent = graph.getDefaultParent();
		mxStylesheet stylesheet = graph.getStylesheet();
		stylesheet.putCellStyle("MyStyle", style);
		stylesheet.putCellStyle("MyStyle2", style2);
		stylesheet.putCellStyle("MyStyle3", style3);
		graph.getModel().beginUpdate();

		try
		{
			int k = 240;
			int j = 200;
			Object v1 = graph.insertVertex(parent, null, actionStatic.owlNamedIndividual.toString().substring(actionStatic.owlNamedIndividual.toString().indexOf("#") + 1, actionStatic.owlNamedIndividual.toString().indexOf(">")), 500, 20, 100, 50, "MyStyle3");

			Object[] it = values.toArray();

			for (int i = 0; i < it.length; i++)
			{

				Object v = graph.insertVertex(parent, null, it[i].toString().substring(it[i].toString().indexOf("#") + 1, it[i].toString().length() - 1), k, j, 60, 60, "MyStyle2");
				k = k + 100;
				j = j + 1;
				graph.insertEdge(parent, null, property.toString().substring(property.toString().indexOf("#") + 1, property.toString().indexOf(">")), v1, v);
			}

		} finally
		{
			graph.getModel().endUpdate();
		}

		final mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);

		graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e)
			{

				Object cell = graphComponent.getCellAt(e.getX(), e.getY());

				if (cell != null)
				{
					System.out.println("cell=" + graph.getLabel(cell));
				}
			}
		});
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * ClickHandler frame = new ClickHandler();
	 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setSize(400,
	 * 320); frame.setVisible(true); }
	 */
}