Question3: Read the color property from the current node and set it as the background of the page.

Answer: Step 1: Add a color property in the page jcr:content

![img_18.png](img_18.png)

<style>
    body {

        background-color:${pageProperties.color @ context='styleToken'};
    }
</style>