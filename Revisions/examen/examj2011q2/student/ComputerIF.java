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
 * Un ordinateur, sur lequel on peut ajouter et retirer des processus.
 * L'ordinateur dispose de ressources (nombre de processus, volume de stockage)
 * �ventuellement limit�es, et donc peut refuser l'ajout de processus suppl�mentaires.
 * Un ordinateur a un nom.
 * 
 * @author O. Bonaventure, Ch. Pecheur
 * @version Dec 2007
 */

public interface ComputerIF
{
    /**
     * @pre  p != null, p ne se trouve pas d�j� sur cet ordinateur
     * @post le processus p a �t� ajout� � cet ordinateur, si les ressources 
     *       n�cessaires sont disponibles.  Retourne true si le processus
     *       a �t� ajout�, false sinon.
     */
    public boolean addProcess(Process p);
    
    /**
     * @pre p != null
     * @post le processus p a �t� retir� de cet ordinateur, si ce processus
     *       se trouve sur cet ordinateur.  Retourne true si le processus
     *       a �t� supprim�, false sinon.
     */
    public boolean removeProcess(Process p);
    
    /**
     * @pre -
     * @post Tous les processus de cet ordinateur ont �t� retir�s.
     */
    public void removeAllProcesses();
    
    /**
     * @pre -
     * @post retourne le nom de l'ordinateur.
     */
    public String getName();

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
    public String getState();
 }
