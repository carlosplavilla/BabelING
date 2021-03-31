
class ArrayLeader {
	public int[] arrayLeader(int K, int M, int[] A) {
	    List<Integer> resultList = new ArrayList<>();
	    
	    for(int i = 0; i <= A.length - K; i++){
	        Map<Integer, Integer> countMap = new HashMap<>();
	        for(int j = i; j < i + K; j++){
	            if(A[j] <= M) {
	                Integer value = Integer.valueOf(A[j]) + 1;
	                if(countMap.get(value) == null) {
	                    countMap.put(value, Integer.valueOf(1));
	                } else {
	                    countMap.put(value, countMap.get(value) + 1);
	                }
	            }
	        }
	        
	        countMap.forEach((k,v) -> {
	            if(v > K/2) {
	                resultList.add(k);
	            }
	        });
	    }
	    
	    int[] result = new int[resultList.size()];
	    
	    for(int i = 0; i < resultList.size(); i++) {
	        result[i] = resultList.get(i);
	    }
	    
        return result;
	}
}