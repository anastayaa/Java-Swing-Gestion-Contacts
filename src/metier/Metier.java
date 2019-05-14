package metier;

public class Metier {
	
	public static String soundex(String nom) {
		
		char premiereLettre=nom.trim().toUpperCase().charAt(0);
		char[] lettres=nom.trim().toUpperCase().substring(1).toCharArray();
		
		for(int i=1; i<lettres.length; i++) {
			switch (lettres[i]) {
			case 'B':
			case 'P':
				lettres[i]='1';break;
			case 'C':
			case 'K':
			case 'Q':
				lettres[i]='2';break;
			case 'D':
			case 'T':
				lettres[i]='3';break;
			case 'L':
				lettres[i]='4';break;
			case 'M':
			case 'N':
				lettres[i]='5';break;
			case 'R':
				lettres[i]='6';break;
			case 'G':
			case 'J':
				lettres[i]='7';break;
			case 'S':
			case 'X':
			case 'Z':
				lettres[i]='8';break;
			case 'F':
			case 'V':
				lettres[i]='9';break;

			default:
				lettres[i]='0';break;
			}
		}
		
		String soundexNom=premiereLettre+"";
		
		for(int i=1; i<lettres.length; i++) {
			if(lettres[i]!=lettres[i-1] && lettres[i]!='0') {
				soundexNom+=lettres[i];
			}
		}
		soundexNom+="0000";
		
		return soundexNom.substring(0, 4);
	}
	
	public static int livenshtein(String s, String t) {
		int n=s.length();
		int m=t.length();
		int constante;
		
		if(n==0) {
			return m;
		}
		else if(m==0) {
			return n;
		}
		
		int d[][]=new int[n+1][m+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				/**
				 * Inisialisation de la premiere ligne
				 */
				if(i==0) {
					d[i][j]=j;
				}
				/**
				 * Inisialisation de la premiere colonne
				 */
				else if(j==0) {
					d[i][j]=i;
				}
				else {
					if(s.charAt(i-1)==t.charAt(j-1)) {
						constante=0;
					}
					else {
						constante=1;
					}
					
					d[i][j]=Math.min(Math.min(d[i-1][j]+1, d[i][j-1]+1), d[i-1][j-1]+constante);
				}
			}
		}
		
		return d[n][m];
	}

}
