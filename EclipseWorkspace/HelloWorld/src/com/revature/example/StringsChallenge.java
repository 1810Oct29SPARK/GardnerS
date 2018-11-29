package com.revature.example;

public class StringsChallenge {
	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 *
	 * @param string
	 * @return
	 */
	public static String reverse(String string) {
		char[] arr = string.toCharArray();
		// System.out.println(arr);
		// now its an array.
		char[] rra = new char[arr.length];
		// System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			//int j = (arr.length-1)-i;
			//rra[j]=arr[i];
			//this is the solution jake had said.
			//It works but its not how i think.
			//this is more akin to how i think.
			//in here i got a mirror set up at the middle.
			//thats how i thought about the problem.
			if (arr.length % 2 == 0) {
				int half = arr.length / 2;
				int spot = half + (half - 1) - i;
				rra[spot] = arr[i];
			} else {
				//problem in here somewhere
				int half = (arr.length - 1) / 2;
				
				
				
				int spot = half + half - i;
				// this is where i had to change stuff for errors.
				rra[spot] = arr[i];
				rra[half + 1] = arr[half + 1];
			}
		}
		// System.out.println(rra);
		String gnirts = new String(rra).substring(0, 1).toUpperCase() + new String(rra).substring(1).toLowerCase();
		return gnirts;
	}

	public static void main(String[] args) {
		System.out.println(reverse("StrEssed"));
		System.out.println(reverse("Regal"));
		//error here. Lagar not Lager.
		System.out.println(reverse("GOD"));
		System.out.println(reverse("0123X5678"));
		//error here. Dod not Dog.
		//the letter after the halfmark doesnt change.
	}
}
