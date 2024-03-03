# Artemis Financial Security Review

The project was to evaluate potential security problems in an existing project using Java. Artemis Financial was concerned about issues in the Spring framework that could potentially leak information, allow for denial of service attacks, or seriously corrupt the data by using malformed queries.

There were some issues found that could be resolved by updating to the most recent version of the Framework, but some dependencies still had issues even with the latest versions. They were to do with handling certain file types, so I recommended that those types should not be used.

Using the OWASP dependency scanner, it finds details of potential exploits and which versions of the libraries are affected. You can suppress error messages that are not relevant (some, for example, were on Android only and would not be a problem on the server version). It's important to maintain a secure code base, as leaks can damage both your companies reputation, and you may even be legally responsible if it is determined that insufficient care was applied.

Using the dependency scanner was a much better way of finding out about potential problems, as it finds nested dependencies, so even if you have a secure package that uses other packages, you can still be informed of the problem if an issue is found with one of those. 

A lot of the issues that were not possible to fix were ones due to parsing YAML file (yet another markup language), and so I recommended against using YAML if possible, as that was an area of concern. Using prepared queries for SQL means you are less concerned about SQL injection where data that includes escapes could cause an additional SQL query to be executed.

Before making changes, I ran the dependency check and checked the issues. Then, after making changes, I reran the dependency check and made sure that no new issues were raised.

THe use of OWASP dependency scanner was very handy for determining potential problems, and the ability to use a supression file avoids having to check the same problem again after the problem has been fixed. 

I would show potential employers the list of problems before and after the fixes, so they can see how many problems I was able to help with.
