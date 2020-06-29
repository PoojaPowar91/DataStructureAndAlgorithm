
class PrimePallindrome {
	  public int primePalindrome(int N) {
	      if(N >= 8 && N <= 11)
	          return 11;
	      
	      for(int i = 1; i < 100000; i++)
	      {
	            String l = String.valueOf(i);
	          String r = new StringBuilder(l).reverse().toString();
	          
	          String cand = l + r.substring(1);
	            int n = Integer.parseInt(cand);
	            if (n >= N && isPrime(n)) return n;
	      }
	      return -1;
	    }
	    
	    private boolean isPrime(int n) {
	        if(n == 1)
	            return false;
	        
	        if(n % 2 == 0)
	            return n == 2;
	            
	        for(int i = 2 ; i <= Math.sqrt(n) ; i++)
	        {
	            if(n % i == 0)
	                return false;
	        }
	        return true;
	    }
	}
