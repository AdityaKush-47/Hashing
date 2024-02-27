import java.util.*;

public class Implementation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V val) {
                this.key = key;
                this.value = val;
            }
        }

        private int N;
        private int n;
        private LinkedList<Node> bucket[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.bucket = new LinkedList[4];
            for(int i = 0; i < 4; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int idx = key.hashCode();
            return Math.abs(idx) % bucket.length;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = bucket[bi];
            int di = 0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

       
        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = bucket[bi].get(di);
                node.value = value;
            } else {
                bucket[bi].add(new Node(key, value));
                n++;
            }

            float lambda = (float) (n / N);
            if (lambda > 2) {
                rehash();
            }

        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBucket[] = bucket;
            bucket = new LinkedList[N * 2];
            N = N * 2;
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }

        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = bucket[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = bucket[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> key = new ArrayList<>();

            for(int i = 0;i<bucket.length;i++) {
                LinkedList<Node> ll = bucket[i];
                for(Node node : ll) {
                    key.add(node.key);
                }
            }
            return key;
        }

        boolean isEmpty(){
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 140);
        map.put("France", 27);
        map.put("Pakistan", 33);
        map.put("Spain", 16);

        ArrayList<String> keys = map.keySet();

        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i));
        }
    }
}