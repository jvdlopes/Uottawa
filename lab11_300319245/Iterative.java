public class Iterative {

	public static BitList complement( BitList in ) {
		BitList ans = new BitList();
		Iterator traverse = in.iterator();
		Iterator travAns = ans.iterator();

		while(traverse.hasNext()){
			int check = traverse.next();
			if(check == 1){
				travAns.add(0);
			}
			else if(check == 0){
				travAns.add(1);
			}
		}
		return ans;
	}

	public static BitList or( BitList a, BitList b ) {
		BitList ans = new BitList();
		Iterator traverse1 = a.iterator();
		Iterator traverse2 = b.iterator();
		Iterator travAns = ans.iterator();
		
		if(!traverse1.hasNext()){
			throw new IllegalArgumentException();
		}
		else if(!traverse2.hasNext()){
			throw new IllegalArgumentException();
		}

		while(traverse1.hasNext()){
			if(traverse2.hasNext()){
				int aint = traverse1.next();
				int bint = traverse2.next();
				if(aint == 1 || bint == 1){
					travAns.add(1);
				}
				else{
					travAns.add(0);
				}
			}
			else{
				throw new IllegalArgumentException();
			}
		}
		if(traverse2.hasNext()){
			throw new IllegalArgumentException();
		}
		return ans;
	}

	public static BitList and( BitList a, BitList b ) {
		BitList ans = new BitList();
		Iterator traverse1 = a.iterator();
		Iterator traverse2 = b.iterator();
		Iterator travAns = ans.iterator();
		
		if(!traverse1.hasNext()){
			throw new IllegalArgumentException();
		}
		else if(!traverse2.hasNext()){
			throw new IllegalArgumentException();
		}

		while(traverse1.hasNext()){
			if(traverse2.hasNext()){
				int aint = traverse1.next();
				int bint = traverse2.next();
				if(aint == 1 && bint == 1){
					travAns.add(1);
				}
				else{
					travAns.add(0);
				}
			}
			else{
				throw new IllegalArgumentException();
			}
		}
		if(traverse2.hasNext()){
			throw new IllegalArgumentException();
		}
		return ans;
	}

	public static BitList xor( BitList a, BitList b ) {

		BitList ans = new BitList();
		Iterator traverse1 = a.iterator();
		Iterator traverse2 = b.iterator();
		Iterator travAns = ans.iterator();
		
		if(!traverse1.hasNext()){
			throw new IllegalArgumentException();
		}
		else if(!traverse2.hasNext()){
			throw new IllegalArgumentException();
		}

		while(traverse1.hasNext()){
			if(traverse2.hasNext()){
				int aint = traverse1.next();
				int bint = traverse2.next();
				if(aint == 1 || bint == 1){
					if(aint == 1 && bint == 1){
						travAns.add(0);
					}
					else{
						travAns.add(1);
					}
				}
				else{
					travAns.add(0);
				}
			}
			else{
				throw new IllegalArgumentException();
			}
		}
		if(traverse2.hasNext()){
			throw new IllegalArgumentException();
		}
		return ans;
	}

    
}