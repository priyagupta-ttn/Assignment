
####  Question 1 Print current time.

Create java class 

package com.example.core.models;

import com.adobe.cq.sightly.WCMUsePojo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime extends WCMUsePojo {

    private String currentTime;

    @Override
    public void activate() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        currentTime = formatter.format(date);
    }

    public String getCurrentTime() {
        return currentTime;
    }
}

HTL Script

<sly data-sly-use.currentTime="com.example.core.models.CurrentTime">
    <div>
        Current Time: ${currentTime.currentTime}
    </div>
</sly>

 ##### Question 2 2.) Create a list of resources under /content/my-options and add two properties "text"
and "value" on each resource. Create a dropdown (HTMl select) using the resources
list as options.

Answer - Need to discuss

#### Question 3 3.) Read the color property from the current node and set it as the backgorund of the page.

Answer -<html>
<head>
    <title>Demo Page</title>
    <style>
        body {

            background-color:${currentPage.color};
        }
    </style>
</head>
<body>

    <h1>Welcome to the Demo Page</h1>
    <p>This page has a dynamic background color.</p>
</body>
</html>

#### Question 4 4.) Add the dropdown created in Q-2 under two different containers (div tag) with different background colors.

Answer - need to discuss



