vestedAutomateLoginAndListStocks.java contains the code for automating the following operations:
1) Login operation on vested app
2) Go to Dashboard > Explore > Top Movers and click on View all
3) On Explore page, click on the various column header to verify
sort is working as expected
4) Verify Sort for column names - Name, Symbol, Price, Daily
Change, Market Cap, P/E Ratio
5) Click on the "heart" against the stock to Watchlist,
6) Open the stock page to verify the stock has been “added to
watchlist”.
7) Verify that there are 20 stocks displayed in the table

Description of the code: 
1) The code first launches the Chrome Browser using ChromeDriver class. 
2) With the help of ChromeDriver class, the login operation is performed by navigating to URL "https://app.vested.co.in/login", finding the login elements and 
   submitting the login form.
3) Then the code clicks on "Allow" button on the alert pop-up. Also, the code clicks on the other alert pop-up to get to the vested application.
4) The code then goes to Go to Dashboard > Explore > Top Movers
5) The list of stocks are displayed in the browser. 
6) The code clicks on various columns names one by one: Name, Symbol, Price, Daily Change, Market Cap, P/E Ratio. The list for each column name is stored after each click to check if the sorting functionality is working. The appropriate message is displayed in the console.
7) Once the sorting functionality is verfied , code clicks on "heart" against the stock to add to Watchlist, opens the stock page to verify the stock has been “added to
watchlist”. 


