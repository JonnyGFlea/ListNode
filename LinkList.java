
public class LinkList{
	private ListNode head;
	
	public void addToFront(Object item){
		head = new ListNode(item,head);
	}
   public void addToBack(Object item){
   ListNode curr = head;
        if(curr == null)
        {
            //System.out.println("made it to the addto front");
            addToFront(item);
            return;
        }
        for(curr = head; curr.getNext() != null; curr = curr.getNext())
        {
        }  
   //System.out.println("we made it to new entry in back");
   curr.setNext(new ListNode(item,null));
	         }
	public void remove(Object item){
      ListNode curr = head;
      ListNode prev = null;
      if(curr == null)
         return;
      while(curr != null && !curr.getValue().equals(item))//not found 
      //make sure you do NOT hit the end of the list USE short-circuit
      {
         //System.out.println("while loop");
         prev = curr;
         curr = curr.getNext();
      }
      if(curr == null)
         return;
      if(prev == null)
            {
            head = head.getNext();
            }
      else
            prev.setNext(curr.getNext());
   }
   public void addInOrder(Object item){
   ListNode curr = head;
   ListNode prev = null;
   
      while(curr != null && ((Comparable)curr.getValue()).compareTo(item) < 0)
      {
         prev = curr;
         curr = curr.getNext();
      }
      if(prev == null)
      {
         head = (new ListNode(item,head)); 
      }
      if(prev != null)
      {
         prev.setNext(new ListNode(item,curr));
      }      
   }
      public void printReversed()
   {
       System.out.println( printReverseHelp(head) );
   }
   
   private String printReverseHelp(ListNode h)
   {
       if (h == null) return "";    
       if (h.getNext() == null) //end of list
          return "" + h.getValue();
   
       return printReverseHelp(h.getNext())+ "-->" +h.getValue()  ;
   
   }
   public void reverse()
   {
       ListNode reversed = reverseHelp(head);
       if (head != null) head.setNext(null);  // old head is new tail
       head = reversed;
   }
   private ListNode reverseHelp(ListNode h)
   {
       // base cases
       if (h == null ) return null;
       if (h.getNext() == null) return h;
       ListNode newHead = reverseHelp(h.getNext()); // recursive case
       h.getNext().setNext(h); // make the next node in the list point 
                               // back to this node
       return newHead;  // this should be the old end of the list,
                        // returned through recursive calls
   }
	public String toString()
	{
		String result = "";
		for (ListNode curr = head; curr != null; curr = curr.getNext())
		{
			result += curr.getValue();
			if (curr.getNext() != null)
				result += "-->";
					
		}
		return result;
	}
	
	public static void main (String args[])
	{
		LinkList list = new LinkList();
		
		String item;
 		EasyReader console = new EasyReader();
		
		int choice;
		do{
					
		System.out.println("Enter choice:");
		System.out.println("1. Add item to head of list");
		System.out.println("2. Add item to end of list");
		System.out.println("3. Delete item from list");
		System.out.println("4. Add item in order");
      System.out.println("5. Make a reversed version");
      System.out.println("6. Print list");
      System.out.println("7. Print reversed version");
      System.out.println("8. Exit");
		
		choice = console.readInt();
		
		if (choice == 1) // Add to head
		{
			System.out.print("Enter item: ");
			item = console.readWord();
			list.addToFront(item);
		}
      if (choice == 2) // Add to back
		{
         System.out.print("Enter item: ");
			item = console.readWord();
         list.addToBack(item);

      }
      if (choice == 3) // Delete
		{
         System.out.print("Enter item: ");
			item = console.readWord();
			list.remove(item);
      }
      if (choice == 4) //add in order
		{
         System.out.print("Enter item: ");
			item = console.readWord();
			list.addInOrder(item);
      }
      if (choice == 5) //Make reversed version
		{
			list.reverse();
		}
		if (choice == 6) //Prints
		{
			System.out.println(list);
		}
      if (choice == 7) //Prints reverse
		{
			list.printReversed();
		}
				
								
		}
		while (choice != 8);
		

}		
}
		