package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other
 * words, convert it to the canonical path.
 * 
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level.
 * 
 * Note that the returned canonical path must always begin with a slash /, and
 * there must be only a single slash / between two directory names. The last
 * directory name (if it exists) must not end with a trailing /. Also, the
 * canonical path must be the shortest string representing the absolute path.
 * 
 * 
 * Example 1:
 * 
 * Input: "/home/" Output: "/home"
 * 
 * Explanation: Note that there is no trailing slash after the last directory
 * name.
 * 
 * 
 * Example 2:
 * 
 * Input: "/../" Output: "/"
 * 
 * Explanation: Going one level up from the root directory is a no-op, as the
 * root level is the highest level you can go.
 * 
 * 
 * Example 3:
 * 
 * Input: "/home//foo/" Output: "/home/foo"
 * 
 * Explanation: In the canonical path, multiple consecutive slashes are replaced
 * by a single one.
 * 
 * 
 * Example 4:
 * 
 * Input: "/a/./b/../../c/" Output: "/c"
 * 
 * 
 * Example 5:
 * 
 * Input: "/a/../../b/../c//.//" Output: "/c"
 * 
 * 
 * Example 6:
 * 
 * Input: "/a//b////c/d//././/.." Output: "/a/b/c"
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String Input = "/home/";
        String output = getSimplifiedPath(Input);
        System.out.println(output + "\n");

        Input = "/../";
        output = getSimplifiedPath(Input);
        System.out.println(output + "\n");

        Input = "/home//foo/";
        output = getSimplifiedPath(Input);
        System.out.println(output + "\n");

        Input = "/a/./b/../../c/";
        output = getSimplifiedPath(Input);
        System.out.println(output + "\n");

        Input = "/a/../../b/../c//.//";
        output = getSimplifiedPath(Input);
        System.out.println(output + "\n");

        Input = "/a//b////c/d//././/..";
        output = getSimplifiedPath(Input);
        System.out.println(output + "\n");
    }

    public static String getSimplifiedPath(String path) {
        Stack<String> s = new Stack<>();
        String[] p = path.split("/");

        for (String currentSplit : p) {
            if (!s.isEmpty() && currentSplit.equals("..")) {
                s.pop();
            } else if (!currentSplit.equals(".") && !currentSplit.equals("") && !currentSplit.equals("..")) {
                s.push(currentSplit);

            }
        }

        List<String> resultDirs = new ArrayList<>(s);

        return "/" + String.join("/", resultDirs);
    }

}