
public void class NavyBattle {


//private void Draw()
{
    string abc = "12345abcde";
    string[,] sCoordinates = new string[2,5];
    for(int i = 0 ; i <= 9 ; i++)
    {
        //populate the array
        if(i == 5)
        {
            iCol = 0;
            iRow += 1;
        }
        sCoordinates[iRow,iCol] = abc.Substring(0,1);
        abc = abc.Remove(0,1);
        iCol += 1;
    }
    float fLocal = (float)60;
    float fX = (float)iX;
    float fY = (float)iY;
    Font font = new Font("Arial", 10);
    SolidBrush sBlack = new SolidBrush(Color.Black);
    Point pLocation = new Point(iX, iY);
    PointF pfLocation = new PointF(fX, fY);
    Pen pen = new Pen(new SolidBrush(Color.Black), 3);
    //Setting the row and column to origin
    iRow = 0;
    iCol = 0;
    pfLocation.X += 25;
    pfLocation.Y = fLocal;
    for(int iCount = 0 ; iCount <= 9 ; iCount++)
    {
        //put numbers
        if(iCount <= 4)
        {
            m_FormGraphs.DrawString(sCoordinates[iRow, 
               iCol].ToString(),font, sBlack, pfLocation);
            pfLocation.X += 50;
        }
        //put letters
        else
        {
            if(iCount == 5)
            {
                pfLocation.X = 10;
                pfLocation.Y += 40;
                iRow +=1;
                iCol = 0;
            }
            m_FormGraphs.DrawString(sCoordinates[iRow, 
                iCol].ToString(),font, sBlack, pfLocation);
            pfLocation.Y += 50;
        }
        iCol += 1;
    }
    //to draw 5 squares in a row
    for(int iOtherCount = 0; iOtherCount < 5 ; iOtherCount++)
    {
        //to draw 1 square in each column
        for(int j = 0 ; j < 5 ; j++)
        {
            m_FormGraphs.DrawRectangle(pen, pLocation.X, 
                      pLocation.Y, m_iWidth, m_iHeight);
            pLocation.X += 50;
        }
        pLocation.X = iX;
        pLocation.Y += 50;
    }
}