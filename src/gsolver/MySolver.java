/**
 * 
 *     This file is part of ag41-2016P-challenge-transshipment
 *     
 *     ag41-2016P-challenge-transshipment is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *     
 *     ag41-2016P-challenge-transshipment is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *     
 *     You should have received a copy of the GNU General Public License
 *     along with ag41-2016P-challenge-transshipment.  If not, see <http://www.gnu.org/licenses/>.
 *     
 */
package gsolver;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.text.TabableView;

import gproblem.GNode;
import gproblem.GEdge;
import gproblem.GTransshipmentProblem;
import gsolution.GTransshipmentSolution;
import gsolver.GSolver;


/**
 * 
 * @author Olivier Grunder
 * @version 0.01
 * @date 7 march 2016
 *
 */
public class MySolver extends GSolver {
	
	ArrayList<GNode> clients;
	ArrayList<GNode> platforms;
	ArrayList<GNode> depots;
	/**
	 * 
	 */
	public MySolver() {
		super();
		clients = new ArrayList<GNode>();
		platforms = new ArrayList<GNode>();
		depots = new ArrayList<GNode>();
	}

	/**
	 * @param problem
	 */
	public MySolver(GTransshipmentProblem problem) {
		super(problem);
	}

	/**
	 * solves the problem
	 */
	/* (non-Javadoc)
	 * @see gsolver.GSolver#solve()
	 */
	public void solve() {
		System.out.println("This is mysolver...") ;
		System.out.println("Génération des clients");
		buildClients(problem);
		buildPlatforms(problem);
		buildDepots(problem);
		System.out.println(clients);
		System.out.println(platforms);
		System.out.println(depots);
		System.out.println("-------------------");
		problemChange();
		bestSolution = null ;
		currentSolution = null ;
	}

	private void buildClients(GTransshipmentProblem pb) {
		ArrayList<GNode> newClients =new ArrayList<>();
		for (GNode node : pb.getTabNodes()){
			if(node.getDemand() > 0){
				newClients.add(node);
			}
		}
		this.clients = newClients;
	}

	private void buildPlatforms(GTransshipmentProblem pb) {
		ArrayList<GNode> newPlatforms =new ArrayList<>();
		for (GNode node : pb.getTabNodes()){
			if(node.getDemand() == 0){
				newPlatforms.add(node);
			}
		}
		this.platforms = newPlatforms;
	}

	private void buildDepots(GTransshipmentProblem pb) {
		ArrayList<GNode> newDepots =new ArrayList<>();
		for (GNode node : pb.getTabNodes()){
			if(node.getDemand() < 0){
				newDepots.add(node);
			}
		}
		this.depots = newDepots;
	}

	private void problemChange(){
		ArrayList<GNode> newPlt = new ArrayList<>();
		for(GNode n : problem.getTabNodes()) {
			/*
			 * for every platform, it creates the secondary
			 * platform (mini-platform) directed from depots and adds it to
			 * newPlt
			 */
			if(n.getDemand()==0){
				for (int i = 0; i < this.depots.size(); i++) {
					newPlt.add(new GNode(problem.getNbrNodes()*10+n.getIndice()*problem.getNbrNodes()+i, 0, 0, 0, 0, 0));
				}
			}
		}
		System.out.println("test\n"+newPlt);
		ArrayList<GEdge> newEd = new ArrayList<>();
		/*for(GEdge e: problem.getTabEdges()) {

			if (platforms.contains(e.getEndingNode())) {
				newEd.add(new GEdge(problem.getNbrEdges()+e.getIndice(), e.getStartingNode(), newPlt.get(e.getEndingNode().getIndice()+problem.getNbrNodes()), e.getCapacity(), e.getEndingNode().getCost(), 0, 0));
			}
		}*/

		/*for(GEdge e: problem.getTabEdges()) {
			if (platforms.contains(e.getStartingNode())) {
				newEd.add(new GEdge(problem.getNbrEdges() + e.getIndice(),newPlt.get(e.getStartingNode().getIndice() + problem.getNbrNodes()+depots.size()),  e.getEndingNode(), e.getCapacity(), e.getEndingNode().getCost(), 0, 0));
			}
		}*/
		/*
		 * used to detect every edge ending to a
		 * platform and create a secondary edge to the
		 * corresponding mini-platform and adds them
		 * to newEd
		 */
		for(GNode n : newPlt){
				for (GNode d : depots)
					newEd.add(new GEdge(n.getIndice()*problem.getNbrNodes() + d.getIndice(), d, n, 100000, problem.getNode((n.getIndice() - problem.getNbrNodes() * 10) / problem.getNbrNodes()).getCost(), 0, 0));
		}
		for(GNode n : problem.getTabNodes()) {
			/*
			 * for every platform, it creates the secondary
			 * platform (mini-platform) directed to clients and adds it to
			 * newPlt
			 */
			if (n.getDemand() == 0) {
				for (int i = 0; i < this.clients.size(); i++) {
					newPlt.add(new GNode(problem.getNbrNodes() * 10 + n.getIndice() * problem.getNbrNodes() + depots.size() + i, 0, 0, 0, 0, 0));
				}
			}
		}

		for (GNode n : newPlt) {
			int i = 0;/*i introduced to avoid edge built from first platforms to clients*/
			for(GNode d : clients){
				System.out.print(n.getIndice() + ", ");
				if(n.getIndice()-problem.getNbrNodes()*10>clients.size()+platforms.size()) {
					newEd.add(new GEdge(n.getIndice() * problem.getNbrNodes() + d.getIndice(), n, d, 100000, problem.getNode((n.getIndice() - problem.getNbrNodes() * 10) / problem.getNbrNodes()).getCost(), 0, 0));
				}
				i++;
			}
		}

		System.out.println("test\n"+newPlt);
		System.out.println(newEd);
	}
}
