##### Question 1 - Taking up a list of potential scripts for a request to a resource whose sling:resource
##### type is example/sample and the request selectors are "print.a4" and the request extension is "html". What would be the order in which these scripts would be called ?

(0) GET.jsp

(1) sample.jsp

(2) html.jsp

(3) print.jsp

(4) print.html.jsp

(5) print/a4.jsp

(6) print/a4/html.jsp

(7) print/a4.html.jsp

Answer
Below is the priority of resolution in Descending order(Highest to lowest):-

Selector +Extension .jsp –> test.myComponent.html.jsp

Selector.jsp –> test.jsp

Extension.jsp –>html.jsp

Node Name.jsp –> myComponent.jsp

method name.jsp(Based on type of request we make Either GET or POST) –> GET.jsp or POST.jsp

------------------------------------------------------------
Scripts in the order they got called

1 print/a4.html.jsp

2 print/a4/html.jsp

3 print/a4.jsp

4 print.html.jsp

5 print.jsp

6 sample.jsp

7 html.jsp

8 GET.jsp