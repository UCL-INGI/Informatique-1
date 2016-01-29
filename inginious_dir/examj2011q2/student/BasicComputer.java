/**
 *  Copyright (c) 2015, 2016 François Michel, Clémentine Munyabarenzi
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */



package student;
/**
 * Un ordinateur de base, supportant un seul processus et sans capacit� de stockage.
 * 
 * @author O. Bonaventure, Ch. Pecheur
 * @version Dec. 2007
 */
public class BasicComputer implements ComputerIF
{
    private String name; // Nom de l'ordinateur
    private Process proc; // processus �ventuel, null si absent
    
    /**
     * @pre name != null
     * @post Construit un BasicComputer de nom name.
     */
    public BasicComputer(String name)
    {
        this.name = name;
    }

    /**
     * @pre -
     * @post retourne le nom de l'ordinateur.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @pre  p != null, p ne se trouve pas d�j� sur cet ordinateur
     * @post le processus p a �t� ajout� � cet ordinateur, si aucun processus
     *       n'est pr�sent et si p ne demande pas de stockage. Retourne true si
     *       le processus a �t� ajout�, false sinon.
     */
    public boolean addProcess(Process p) 
    {
    	if (proc == null && p.getRequiredStorage() == 0) {
    		proc = p;
    		return true;
    	} else {
    		return false;
    	}
    }

    /**
     * @pre p != null
     * @post le processus p a �t� retir� de cet ordinateur, s'il s'agit bien du
     *       processus pr�sent. Retourne true si le processus a �t� supprim�,
     *       false sinon.
     */
    public boolean removeProcess(Process p) 
    {
    	if (proc.equals(p)) {
    		proc = null;
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * @pre -
     * @post Tous les processus de cet ordinateur ont �t� retir�s. Retire proc
     *       s'il est actif.
     */
    public void removeAllProcesses()
    {
    	proc = null;
    }
    
    /**
     * @pre -
     * @post Retourne la liste des processus de cet ordinateur sous forme de texte,
     *       avec une ligne par processus, chaque ligne comprenant le nom du processus
     *       et sa taille de stockage, s�par�s par un espace, et se termine par
     *       un passage � la ligne.  Par exemple:
     *     
     *       process1 0
     *       bigprocess 200
     *       smallprocess 20
     */
    public String getState() {
    	if (proc != null) {
    		return proc.toString() + "\n";
    	} else {
    		return "";
    	}
    }
    
    //////////////////////
    
    /**
     * pour debugging
     */
    public String toString()
    {
    	return getName() + " (" + (proc == null ? "avail" : "busy") + ")";
    }

}
