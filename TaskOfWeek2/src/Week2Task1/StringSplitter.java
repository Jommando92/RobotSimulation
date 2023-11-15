package Week2Task1;

import java.util.Arrays;

public class StringSplitter {
    private String[] manyStrings;

    public StringSplitter(String input, String delimiter) {
        this.manyStrings = input.split(delimiter);
    }

    public String[] getStrings() {
        return Arrays.copyOf(manyStrings, manyStrings.length);
    }

    public static void main(String[] args) {
        StringSplitter ME = new StringSplitter("2 5 6 9", " ");
        System.out.println(Arrays.toString(ME.getStrings()));

        String[] temp = ME.getStrings();
        temp[0] = "fred";

        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(ME.getStrings()));
    }

	public int[] getIntegers() {
		return null;
	}
}
