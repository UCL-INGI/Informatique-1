/**
 *  Copyright (c) 2015 François Michel, Clémentine Munyabarenzi
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
 * Un processus, avec un nom (String), une capacité de stockage requise (int) 
 * et un identifiant de processus, ou PID (int).
 * Les PIDs sont attribués séquentiellement à la création de chaque nouveau processus
 * (1 pour le premier, 2 pour le deuxième, etc.).
 * 
 * @author O. Bonaventure, Ch. Pecheur
 * @version Dec. 2007
 */
public class Process //implements ProcessIF
{
    private static int nextPid = 1; // PID du prochain processus

    private String name; // nom du processus
    private int pid; // numéro d'identification
    private int requiredStorage; // espace de stockage nécessaire
    
    /**
     * @pre  name != null, name ne contient pas d'espaces
     * @post construit un processus de nom name et de capacité demandée storage
     */
    public Process(String name,int storage)
    {
        assert name != null;
        this.name = name;
        this.pid = nextPid;
        this.requiredStorage = storage;
        nextPid++;    
    }

    /**
     * @pre -
     * @post retourne le nom du processus
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @pre -
     * @post retourne la capacité de stockage nécessaire
     */
    public int getRequiredStorage()
    {
        return requiredStorage;
    }
    
    /**
     * @pre -
     * @post retourne l'identifiant du processus
     */
    public int getPid()
    {
        return pid;   
    }
    
    /**
	 * @pre -
	 * @post Retourne une chaîne de caractères comprenant le nom du processus
	 *       et la capacité de stockage nécessaire, séparés par un espace.
	 */
    public String toString()
    {
    	return getName() + " " + getRequiredStorage();
    }
    
    ///////////////

    /**
     * @pre o!=null
     * @post 
     */
    // NOT USED
    public boolean equals(Object o)
    {
        assert o!=null;
        if(!(o instanceof Process ))
            return false;
        Process p=(Process) o;    
        return  (pid==p.getPid())&&(requiredStorage==p.getRequiredStorage())&&(name.equals(p.getName())); 
    }
    
    
    /**
     * dummy test
     */
    public static void main(String[] args)
    {
        Process p1,p2,p3;
        p1=new Process("p1",0);
        p2=new Process("p2",2);
        p3=new Process("p2",2);
        
        System.out.println(p1+" "+p2+" "+p3);
        
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p2==p3);
    }
    
}   
