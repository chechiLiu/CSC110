Reads input text file with Scanner and put each String into an Array.
Outputs different results, depending on which method is called.
Input String will all contain between 2 and 4 of the possible bases (A to Z).

	Ex) {ABCD, CDAE, AB, AWS}
  
A mutated input String contains at least two of the same bases occurring in a row.

	Ex) {AABCD, BBCDEE, AAC, AAAAAAAABBCC}
  
printArray():　prints out all the Strings.

findLongest(): returns the longest String. If two Strings have the same length, return the String that was visited first.

findFrequency(): returns the number of a specific String found in the input.

findFreqWithMutations(): returns the number of a specific String found in the input, ignoring mutations.

	Ex) AAAAAAABBBBC = ABC
  
countTotalMutations(): returns the number of Strings with mutation.
