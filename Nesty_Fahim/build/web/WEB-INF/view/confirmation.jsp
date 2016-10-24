<%-- 
    Document   : confirmation
    Created on : Oct 22, 2016, 11:41:59 AM
    Author     : Fahim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Nesty.css">
        <title>The Affable Bean</title>
    </head>
    <body>
        <div id="main">
            

            <div id="singleColumn">

                <p id="confirmationText">
                    [ text ]
                    <br><br>
                    [ order reference number ]
                </p>

                <div class="summaryColumn" >

                    <table id="orderSummaryTable" class="detailsTable" >
                        <tr class="header">
                            <th style="padding:10px">[ order summary table ]</th>
                        </tr>
                    </table>

                </div>

                <div class="summaryColumn" >

                    <table id="deliveryAddressTable" class="detailsTable">
                        <tr class="header">
                            <th style="padding:10px">[ customer details ]</th>
                        </tr>
                    </table>
                </div>
            </div>

            
        </div>
    </body>
</html>
