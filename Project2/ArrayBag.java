package Project2;


public class ArrayBag<T> implements BagInterface<T> {

private final T[] bag;
private int numberOfEntries;
private static final int DEFAULT_CAPACITY = 25;
boolean integrityOK = false;

// creates empty bag

public ArrayBag() {
this(DEFAULT_CAPACITY);
}

// creates empty bag having a desired capacity

//public ArrayBag(int desiredCapacity) {
//T[] tempBag = (T[]) new Object[desiredCapacity];
//bag = tempBag;
//numberOfEntries = 0;
//}

public ArrayBag(int desiredCapacity) {
	T[] tempBag= (T[]) new Object[desiredCapacity];
	bag=tempBag;
	numberOfEntries=0;
}

@Override
public int getCurrentSize() {
// TODO Auto-generated method stub
return 0;
}

@Override
public boolean isEmpty() {
// TODO Auto-generated method stub

return numberOfEntries == 0;
}

private boolean isArrayFull()
{
return numberOfEntries >= bag.length;
}

@Override
/** Adds a new entry to this bag.
@paramnewEntry  the object to be added as a new entry.
@returnTrue if the addition is successful, or false if not.*/
public boolean add(T newEntry)
{
boolean result = true;
if (isArrayFull())
{
result = false;
}
else
{  // Assertion: result is true here
bag[numberOfEntries] = newEntry;
numberOfEntries++;
} // end if
return result;
} // end add


//private void checkIntegrity()
//{
//if (!integrityOK)
//throw new SecurityException("ArrayBag object is corrupt.");
//} // end checkIntegrity

//private void checkIntegrity() {
//	if (!integrityOK) 
	//	throw new SecurityException("ArrayBag object is corrupt.");
//}



@Override
/** Removes one unspecified entry from this bag, if possible.
@returnEither the removed entry, if the removal
was successful, or null. */
public T remove()
{
checkIntegrity();
T result = null;
if (numberOfEntries > 0)
{
result = bag[numberOfEntries - 1];
bag[numberOfEntries - 1] = null;
numberOfEntries--;
} // end if
return result;
} // end remove
@Override
public boolean remove(T anEntry) {
// TODO Auto-generated method stub
return false;
}

@Override
public void clear() {
// TODO Auto-generated method stub

}

//@Override
/** Counts the number of times a given entry appears in this bag.
@paramanEntry  The entry to be counted.
@returnThe number of times anEntry appears in this bag. */
//public int getFrequencyOf(T anEntry)
//{
//checkIntegrity();
//int counter = 0;
//for (int index = 0; index < numberOfEntries; index++)
//{
//if (anEntry.equals(bag[index]))
//{
//counter++;}
//} // end if
//}
@Override
public int getFrequencyOf(T anEntry) {
	int counter=0;
	for (int index=0; index<numberOfEntries; index++) {
		if(anEntry.equals(bag[index])) {
			counter++;
		}
	}
	return counter;
}
private void checkIntegrity() {
	boolean integrityOK = false;
	if (!integrityOK) {
		throw new SecurityException("ArrayBag object is corrupt.");
	}
}


@Override


public boolean contains(T anEntry)
{
checkIntegrity();
boolean found = false;
int index = 0;      
while (!found && (index < numberOfEntries))
{
if (anEntry.equals(bag[index]))
{
found = true;
} // end if
index++;
} // end while
return found;
} // end contains



/** Retrieves all entries that are in this bag.
@return A newly allocated array of all 
the entries in the bag. */
public T[] toArray() 
{
// The cast is safe because the new array 
// contains null entries.
@SuppressWarnings("unchecked")
T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
for (int index = 0; index < numberOfEntries; index++) 
{
result[index] = bag[index];
} // end for
return result;
} // end toArray

}