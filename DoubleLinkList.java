public class DoubleLinkList
{
private DNode head;
private DNode tail;

	
	public void addToFront(Object item){
      if(head == null)
      {
      	head = new DNode(item,head,tail);
         tail = head;
      }
      else
      {
         head = new DNode(item,head,null);
         head.getNext().setPrev(head);
         
      }
         

	}
   public void addToBack(Object item){
      DNode curr = tail;
           if(curr == null)
           {
               addToFront(item);
               return;
           }
           else
           {
           tail = new DNode(item,null,tail);
           tail.getPrev().setNext(tail);
           }
   }
	public void deleteItem(Object item){
      DNode curr = head;
      if(curr == null)
         return;
      while(curr != null && !curr.getValue().equals(item))//not found 
      {
         curr = curr.getNext();
      }
      if(curr == null)
         return;
      if(curr == head) //delete first node
            {
            deleteFromFront();
            }
      else
         if(curr == tail)
            {
            deleteFromBack();
            }
         else
         {
            curr.getPrev().setNext(curr.getNext());
            ((DNode)curr.getNext()).setPrev(curr.getPrev());
         }
   }
   public void addInOrder(Object item){
      DNode curr = head;
      while(curr != null && ((Comparable)curr.getValue()).compareTo(item) < 0) 
         {
         curr = curr.getNext();
         }
      if(curr == head)
      {
         addToFront(item);
      }
      else
         if(curr == null)
         {
            addToBack(item);
         } 
         else
         {
            DNode prev = curr.getPrev();
            DNode temp = curr;
            DNode added = new DNode(item,temp,prev);
            prev.setNext(added);
            temp.setPrev(added); 
         }
  
   
   }
   public void printBackwards(){
      String total = "";
      for(DNode curr = tail; curr!=null; curr = curr.getPrev())
         {
            if(curr.getPrev() != null)
            {
               total += (curr.getValue() + "-->");
            }
            else
            {
               total += (curr.getValue());
            }
         }
      System.out.println(total);
   
   
   }
   public void deleteFromFront(){
      if(head == null)
      {
         return;
      }
      if(head.getNext() != null)
         {
            DNode temp = head.getNext();
            temp.setPrev(null);
            head = temp;
         }
       else
         {
            head = null;
            tail = null;
         }
   }
   public void deleteFromBack(){
      if(tail == null)
      {
         return;
      }
      
      if(tail != null)
      {
         if(tail.getPrev() != null)
         {
            DNode temp = tail.getPrev();
            temp.setNext(null);
            tail = temp;
         }
         else
         {
            head = null;
            tail = null;
         }
      }

   }
	public String toString()
	{
		String result = "";
		for (DNode curr = head; curr != null; curr = curr.getNext())
		{
			result += curr.getValue();
			if (curr.getNext() != null)
				result += "-->";
					
		}
		return result;
	}
	
	public static void main (String args[])
	{
		DoubleLinkList list = new DoubleLinkList();
		
		String item;
 		EasyReader console = new EasyReader();
		
		int choice;
		do{
					
        System.out.println("Enter choice:");
        System.out.println("1. Add item to head of list");
        System.out.println("2. Add item to end of list");
        System.out.println("3. Delete item from list");
        System.out.println("4. Add item in order");
        System.out.println("5. Print list");
        System.out.println("6. Print reversed version");
        System.out.println("7. Delete item from front of list");
        System.out.println("8. Delete item from back of list");
        System.out.println("9. Exit");
		
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
			list.deleteItem(item);
      }
      if (choice == 4) //add in order
		{
         System.out.print("Enter item: ");
			item = console.readWord();
			list.addInOrder(item); 
      }
		if (choice == 5) //Prints
		{
			System.out.println(list);
		}
		
      if (choice == 6) //Print reversed version
		{	
         list.printBackwards();
      }
      if (choice == 7) //Delete item from front of list
		{	
         list.deleteFromFront();
      }
      if (choice == 8) //Delete item from back of list
		{
      	list.deleteFromBack();
      } 
           								
		}
		while (choice != 9);
		

}	






}