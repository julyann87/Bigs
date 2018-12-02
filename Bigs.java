class Bigs {
    // addiert die Ziffernfelder a und b
    public static int[ ] add (int[ ] a, int[ ] b)         { 
    	int l;
    	int k;
    	if(a.length>b.length) {
    		l=b.length;
    		k=a.length;
    	}
    	else {
    		l=a.length;
    		k=b.length;
    	}

		int[]sum=new int[k];
		for(int i=0;i<k;i++) {
			sum[i]=0;
		}
		int ue=0;
    	for(int i=0;i<l;i++) {
    		sum[i]=sum[i]+a[i]+b[i];
    		ue=sum[i]/10;
    		sum[i]=sum[i]%10;
    		if(i+1<k&&ue>0) {
    			sum[i+1]=sum[i+1]+ue;
    		}
    		else if(i+1>=k&&ue>0) {
    			int[] sumneu=new int[sum.length+1];
    			for(int j=0;j<l;j++) {
    			sumneu[j]=sum[j];
    			}
    			sumneu[sumneu.length-1]=ue;

    			sum=sumneu;
    		}
    	}
    	if(k==l) {
    		return sum;
    	}
    	else {
    		if(a.length<b.length) {
    			for(int i=l;i<b.length;i++) {
    				sum[i]=sum[i]+b[i];
    				ue=sum[i]/10;
    	    		sum[i]=sum[i]%10;
    	    		if(i+1<b.length&&ue>0) {
    	    			sum[i+1]=sum[i+1]+ue;
    	    		}
    	    		else if(i+1>=b.length&&ue>0) {
    	    			int[] sumneu=new int[sum.length+1];
    	    			for(int j=0;j<b.length;j++) {
    	    			sumneu[j]=sum[j];
    	    			}
    	    			sumneu[sumneu.length-1]=ue;
    	    			sum=sumneu;
    	    		}
    	    		
    			}
    		
    		}
    		if(b.length<a.length) {
    			for(int i=l;i<a.length;i++) {
    				sum[i]=sum[i]+a[i];
    				ue=sum[i]/10;
    	    		sum[i]=sum[i]%10;
    	    		if(i+1<a.length&&ue>0) {
    	    			sum[i+1]=sum[i+1]+ue;
    	    		}
    	    		else if(i+1>=a.length&&ue>0) {
    	    			int[] sumneu=new int[sum.length+1];
    	    			for(int j=0;j<a.length;j++) {
    	    			sumneu[j]=sum[j];
    	    			}
    	    			sumneu[sumneu.length-1]=ue;
    	    			
    	    			sum=sumneu;
    	    		}
    	    		
    			}
    			
    		}
    		return sum;
    	}
    	
    }
    
    // gibt das Ziffernfeld n in lesbarer dezimaler Form aus
    // bei sehr langen Zahlen soll das Format verwendet werden, welches auch von 
    // bc (s.u.) benutzt wird: Umbruch nach 68 Ziffern mit einem \ am Ende
    static void print (int[ ] n)                          { 
    	int count=0;
    	for(int i=n.length-1;i>=0;i--) {
    		
    		if(i==n.length-1) {
    			System.out.print(n[i]);
    			count++;
    		}
    		else if(count%69==0) {
    			System.out.println("\\");
    			System.out.print(n[i]);
    			count++;
    		}
    		else {
    			System.out.print(n[i]);
    			count++;
    		}
    	}
    	System.out.println();
    }
    // konstruiert ein einstelliges Ziffernfeld aus der Ziffer d
    static int[ ] digit(int d)                            { 
    	if(d>9) {
    		System.out.println("Wert fuer digit ist groesser als 9");
    		System.exit(-1);
    	}
    	int[] a= {d};
    	return a;
    }
    
        // konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
    static int[ ] Null()                                  { 
    	int[] a = {0};
    	return a;
    }
    
    // konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
    static int[ ] One()                                   { 
    	int[] a= {1};
		return a;
    	
    }
    
    // Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
    static int mod10(int[ ] n)                            { 
    	int r= n[0];
    	return r;
    	
    }
    
    // ganzzahliger Quotient bei Division durch 10
    static int[ ] div10(int[ ] n)                         {
    	int[] q=new int[n.length-1];
    	
    	if(q.length==0) {
    		int[] k =Null();
    		return k;
    	}
    	
    	for(int i=0;i<q.length;i++) {
    		q[i]=n[0];
    	}
    	return q;
    		
    }
    
    // Umwandlung einer beliebigen int-Zahl in ein Ziffernfeld
    static int[ ] fromInt(int n)                          { 
    	if(n==0) {
    		int[] neu=Null();
    		return neu;
    	}
    	if(n==1) {
    		int[] neu=One();
    		return neu;
    	}
    	int r=n%10;
    	int[]neu= {r};
    	int x=n/10;
    	while(x>0) {
    		r=x%10;
    		neu = times10(neu);
    		neu[0]=r;
    		x=x/10;
    		
    	}
    	int[] neu2=new int[neu.length];
    	for(int i=0;i<neu.length;i++)
    		neu2[i]=neu[neu.length-1-i];
    	return neu2;
    	
    }
    
    // kopiert den Wert von n
    static int[ ] copy(int[ ] n)                          { 
    	int[]a=new int[n.length];
    	for(int i=0;i<n.length;i++) {
    		a[i]=n[i];
    	}
    	return a;
    }
    
    // multipliziert das Ziffernfeld n mit einer (einstelligen!) int-Zahl
    static int[ ] times(int[ ] n, int d)                  { 
    	int[] prod = Null();
    	for(int i=0;i<d;i++) {
    		prod=add(prod,n);
    	}
    	return prod;
    }
    
    // multipliziert das Ziffernfeld n mit 10
    static int[ ] times10(int[ ] n)                       { 
    	int[]a=new int[n.length+1];
    	a[0]=0;
    	for(int i=1;i<a.length;i++){
    		a[i]=n[i-1];
    	}
    	return a;

    }
    
    // multipliziert zwei Ziffernfelder
    static int[ ] times(int[ ]a, int[ ] b)                { 
    	int[] prodsum=Null();
    	int[] prod=Null();
    	for(int i=0;i<b.length;i++) {
    		prod=times(a,b[i]);
    		for(int k=0;k<i;k++) {
    			prod=times10(prod);
    		}
    		prodsum=add(prodsum,prod);
    	}
    	return prodsum;
    		
    }
    
    // Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
    static boolean less (int[ ] a, int[ ] b)              { 
    	if(a.length<b.length)
    		return true;
    	if(a.length>b.length)
    		return false;
    	int z=0;
    	/*while(i<a.length&&a[a.length-1-i]==b[b.length-1-i]) {
    		i++;
    	}*/
    	for(int i=0;i<a.length;i++) {
    		if(a[a.length-1-i]==b[b.length-1-i]) {
    			
    		}
    		else {
    			z=i;
    			break;
    		}
    			
    	}
    	if(a[a.length-1-z]<b[b.length-1-z])
    		return true;
    	else
    		return false;
    }
    
    // Test auf Gleichheit zweier Ziffernfelder
    static boolean equal (int[ ] a, int[ ] b)             { 
    	if(a.length!=b.length)
    		return false;
    	for(int i=9;i<a.length;i++) {
    		if(a[i]!=b[i])
    			return false;
    	}
    	return true;
    }
    
    // Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt 
    // mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9
    // keine fuehrenden Nullen (ausser bei Null selbst)
    static boolean ok (int[ ] n)                          { 
    	if(n.length==0)
    		return false;
    	if(n[n.length-1]==0&&n.length>1)
    		return false;
		for(int i=0;i<n.length;i++) {
    		if(n[i]<0||n[i]>9)
    			return false;
    	}
    	return true;			
    }
    
    // gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus 
    static void maxDigit(int[] n)                         { 
    	int h[]=new int[10];
    	for(int i=0;i<h.length;i++){
    		h[i]=0;
    	}
    	for(int i=0;i<n.length;i++) {
    		h[n[i]]++;
    	}
		int haeufig=0;
    	for(int i=1;i<=9;i++) {

    		if(h[haeufig]<h[i]) {
    			haeufig=i;
    		}
    	}
    	System.out.println(haeufig);
    }
    
    public static void main (String[] s) {
        int[ ] a = One();
        for (int i=0; i<33222; ++i) { a = times(a, 2); }
        System.out.println("2^33222 hat " + a.length + " Stellen");
        print(a); 
        System.out.println();
        int[ ] b = fromInt(13);
        int[ ] c = copy(b);
        for (int i=1; i<8978; ++i) { c = times(c, b); }
        System.out.println("13^8978 hat " + c.length + " Stellen");
        print(c); 
        System.out.println();
        System.out.println(less(a, c)); // beantwortet die Frage aus der    
                                        // Aufgabenueberschrift
        maxDigit(a); 
        maxDigit(c); 
    } 
}