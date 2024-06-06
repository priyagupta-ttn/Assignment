# Assignment 2

### Question 1 - Taking up a list of potential scripts for a request to a resource whose sling:resource
type is example/sample and the request selectors are "print.a4" and the request
extension is "html". What would be the order in which these scripts would be called
?

(0) GET.jsp

(1) sample.jsp

(2) html.jsp

(3) print.jsp

(4) print.html.jsp

(5) print/a4.jsp

(6) print/a4/html.jsp

(7) print/a4.html.jsp

### Answer 



Below is the priority of
resolution in Descending order(Highest to lowest):-

Selector +Extension .jsp –> test.myComponent.html.jsp

Selector.jsp –> test.jsp

Extension.jsp –>html.jsp

Node Name.jsp –> myComponent.jsp

method name.jsp(Based on type of request we make Either GET or POST) –>
GET.jsp or POST.jsp

---

Scripts in the order they got called

1 print/a4.html.jsp

2 print/a4/html.jsp

3 print/a4.jsp

4 print.html.jsp

5 print.jsp

6 sample.jsp

7 html.jsp

8 GET.jsp

### Question 2 -How Sling will Call the Script on the basis of url.

### Answer :
 http://localhost:4502/content/example/sample.print.a4.html

Breakdown of URL Components

Path: /content/example/sample - This refers to the content path in the repository.

Selectors: print.a4 - These are additional request attributes used to refine the request.

Extension: html - This typically specifies the format of the response.

Resource Type: example/sample - This is the sling:resourceType of the resource located at the given path.

### Sling will resolve the script to call in the following order, from most specific to least specific:

1 Selector +Extension .jsp –> test.myComponent.html.jsp

2 Selector.jsp –> test.jsp

3 Extension.jsp –>html.jsp

4 Node Name.jsp –> myComponent.jsp

5 method name.jsp(Based on type of request we make Either GET or POST) –>
GET.jsp or POST.jsp

### Question 3 - Have a page /content/SlingProject/English/test.html which has resourceType SlingProject/components/page/basepage

### Answer curl command
curl -u admin:admin \
     -F "sling:resourceType=SlingProject/components/page/basepage" \
     -F "jcr:primaryType=cq:Page" \
     -F "jcr:content/jcr:primaryType=cq:PageContent" \
     -F "jcr:content/sling:resourceType=SlingProject/components/page/basepage" \
     -F "jcr:content/jcr:title=Test Page" \
     http://localhost:4502/content/SlingProject/English/test

### Question 4 -2] Create this structure in sling console,

/apps   

  /foo - nt:folder         

  /bar - sling folder

       testNode - nt:unstructured             

       = properties                 

              title->Test Node                 

              description-> This is test node sling

### Answer : created the structure as
![alt text](image.png)