package com.sanjok.generator.utl;

public class URLMatcher {

    /**
     * Matches a given URL against a specified pattern.
     *
     * @param pattern the pattern to match against
     * @param url     the URL to match
     * @return true if the URL matches the pattern, false otherwise
     * <p>Example usage:</p>
     * <pre>{@code
     * boolean result1 = matchUrl("/api/admin/*", "/api/admin/login/update/name/");
     * // This will return false because the URL starts with "/api/admin/" and has more then one subdirectory after it.
     *
     * boolean result2 = matchUrl("/api/admin/**", "/api/admin/login/update/name/extra/");
     * // This will return true because the URL starts with "/api/admin/" but has more than one subdirectory after it.
     * }</pre>
     */

    public static boolean matchUrl(String pattern, String url) {
        if (pattern.length() > url.length()) {
            return false;
        }
        if (url.equals(pattern)) {
            return true;
        }
        if (pattern.endsWith("/*")) {
            String patternWithoutWildcard = pattern.substring(0, pattern.length() - 1);
            boolean isStartsWith = url.startsWith(patternWithoutWildcard);
            String partAfterWildcard = url.substring(pattern.lastIndexOf("/"));
            int subDirCount = partAfterWildcard.split("/").length;
            return isStartsWith && subDirCount <= 2;
        } else if (pattern.endsWith("**")) {
            String patternWithoutWildcard = pattern.substring(0, pattern.length() - 2);
            return url.startsWith(patternWithoutWildcard);
        }
        return false;
    }


    public static void main(String[] args) {
        boolean single = matchUrl("/api/admin/*", "/api/admin/login/update/name/");
        boolean dual = matchUrl("/api/admin/**", "/api/admin/login/update/name/");
        boolean dual1 = matchUrl("/api/admin/user/**", "/api/admin/");

        System.out.println(single);
        System.out.println(dual);
        System.out.println(dual1);
    }

}
