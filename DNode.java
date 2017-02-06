public class DNode
{  
  public DNode(Object initValue, DNode initNext, DNode initPrev) { 
    value = initValue; 
    next = initNext;
    prev = initPrev;
  } 
  public Object getValue() 
  { 
      return value;
  }
  
  public DNode getNext() 
  {
      return next;
  }
  
  public DNode getPrev() 
  {
      return prev;
  }
  
  public void setValue(Object theNewValue) 
  {
      value = theNewValue;
  }
  
  public void setNext(DNode theNewNext)
  {
      next = theNewNext;
  }
  
  public void setPrev(DNode theNewPrev)
  {
      prev = theNewPrev;
  }

  private Object value;
  private DNode next;
  private DNode prev;
}
