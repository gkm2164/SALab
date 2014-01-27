package kr.ac.kaist.salab.page;

import java.util.ArrayList;
import java.util.Iterator;

public class NavNodeIterator implements Iterator<NavComponent> {
	Iterator<NavComponent> thisIt = null;
	ArrayList<NavComponent> nl = null;

	public NavNodeIterator(ArrayList<NavComponent> iterator) {
		// TODO Auto-generated constructor stub
		nl = iterator;
		thisIt = nl.iterator();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return thisIt.hasNext();
	}

	@Override
	public NavComponent next() {
		// TODO Auto-generated method stub
		return thisIt.next();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		thisIt.remove();
	}

}
