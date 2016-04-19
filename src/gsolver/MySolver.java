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

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.text.TabableView;

import gproblem.GNode;
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
}
