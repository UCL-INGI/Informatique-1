/**
 *  Copyright (c) 2015 Olivier Bonaventure, François Michel, Clémentine Munyabarenzi
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

import java.util.List;
import java.util.ArrayList;

/**
 *  @author François MICHEL
 */


public class M6Q9Stu{
	String prenom;
	String nom;
	int cote;
	private static ArrayList<M6Q9Stu> listavecunnombizarrequicontientlescotesetlesnoms__ = new ArrayList<M6Q9Stu>();
	public static List<M6Q9Stu> lireCotes() {
@		@q1@@		/*1*/
        while (
@			   @q2@@		/*2*/
			  ){     			
            String prenom = TextIO.getWord();
            String nom = TextIO.getWord();
            int cote = TextIO.getInt();
            TextIO.getln();
            listavecunnombizarrequicontientlescotesetlesnoms__.add(
					 new M6Q9Stu(prenom, nom, cote)
					 );
        }
        System.out.println("Le fichier a été lu entièrement.");
        return listavecunnombizarrequicontientlescotesetlesnoms__;
    }
    public M6Q9Stu(String prenom, String nom, int cote){
		this.prenom = prenom;
		this.nom = nom;
		this.cote = cote;
	}
	
	public boolean equals(Object o){
		if(o == null || !(o instanceof M6Q9Stu)){
			return false;
		}
		M6Q9Stu m = (M6Q9Stu) o;
		return prenom.equals(m.prenom) && nom.equals(m.nom) && cote == m.cote;
	}

	public String toString(){
		return nom + ", " + prenom + ": " + cote;
	}

}
