class Timestampvalue{
    int timestamp;
    String value;
    public Timestampvalue(int timestamp, String value){
        this.timestamp=timestamp;
        this.value=value;
    }
}


class TimeMap {
    public Map<String,ArrayList<Timestampvalue>> mp;
    public TimeMap() {
        mp=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key)){
            mp.put(key,new ArrayList<>());
        }

        ArrayList<Timestampvalue> arr=mp.get(key);
        arr.add(new Timestampvalue(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)) return "";

        ArrayList<Timestampvalue> arr=mp.get(key);
        int idx=binarysearch(arr,timestamp);
        if(idx==-1) return "";

        return arr.get(idx).value;
    }

    private int binarysearch(ArrayList<Timestampvalue> arr, int target){
        int left=0, right=arr.size()-1;
        int match=-1;

        while(left<=right){
            int mid=(left+right)/2;
          
            if(arr.get(mid).timestamp<=target){
                match=mid;
                left=mid+1;
            }

            else{
                right=mid-1;

            }

        }

        return match;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */