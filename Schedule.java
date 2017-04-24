
public class Schedule {

	ClassNode head;

	private class ClassNode{
		ClassNode left, right;
		AClass data;
		public int start;

		ClassNode(AClass p){
			data = p;
			start = p.getStartTimeH();
		}

		ClassNode FindMin(){
			if (left == null){
				return this;
			}
			else {
				return left.FindMin();
			}

		}
	}

	public void AddClass(AClass p, ClassNode target){
		ClassNode newClass = new ClassNode(p);
		if (target == null){
			target = newClass;
		}
		else{
			if (newClass.start < target.start){
				AddClass(p, target.left);
			}
			else {
				AddClass(p, target.right);
			}
		}
	}

	public AClass SearchClass(String p_title, int p_start){
		return Search(p_title, p_start, head).data;
	}

	private ClassNode Search(String p_title, int p_start, ClassNode target){

		if (target == null){
			return new ClassNode(null);
		}

		if (p_title == target.data.getClassTitle()){
			return target;
		}

		if (p_start < target.start){
			return Search(p_title, p_start, target.left);
		}

		else {
			return Search(p_title, p_start, target.right);
		}

	}


	public void RemoveClass(AClass target){
		RemoveClass(target.getClassTitle(), target.getStartTimeH());
	}

	//Based on: http://bit.ly/2pXFgy4
	public void RemoveClass(String p_title, int p_start){

		ClassNode parent = null;
		ClassNode node = head;
		while (node != null)
		{
			if (node.start == p_start && node.data.getClassTitle() == p_title)
			{
				if (parent == null)
				{
					node = null;
				}
				else
				{
					ClassNode min = node.right.FindMin();
					min.left = node.left;
					min.right = node.right;
					if (parent.left == node){
						node.data = min.data;
						node.start = min.start;
						min = null;
					}
					else if (parent.right == node){
						node.data = min.data;
						node.start = min.start;
						min = null;
					}
				}
				return;
			}
			if (p_start < node.start)
			{
				// go down left branch
				parent = node;
				node = node.left;
			}
			else
			{
				// go down right branch
				parent = node;
				node = node.right;
			}
		}
	}

	
	public boolean DoesCollisionExist(Schedule other){
		return DoesCollisionExist(head, other.head);
	}
	
	private boolean DoesCollisionExist(ClassNode p_a, ClassNode p_b){

		if (p_a.left != null){
			if (p_b.left != null){
				DoesCollisionExist(p_a.left, p_b.left);
			}
			DoesCollisionExist(p_a.left, p_b);
			if (p_b.right != null){
				DoesCollisionExist(p_a.left, p_b.right);
			}
		}

		if (p_b.left != null){
			DoesCollisionExist(p_a, p_b.left);
		}
		
		//Basis of recursion
		if(!p_a.data.isCollision(p_b.data)){
			return true;
		};
		
		
		if (p_b.right != null){
			DoesCollisionExist(p_a, p_b.right);
		}
	

	if (p_a.right != null){
		if (p_b.left != null){
			DoesCollisionExist(p_a.right, p_b.left);
		}
		DoesCollisionExist(p_a.right, p_b);
		if (p_b.right != null){
			DoesCollisionExist(p_a.right, p_b.right);
		}
	}
	
	return false;
}
}
