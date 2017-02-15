package com.nacre.online_assesment.action;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.nacre.online_assesment.exception.AssessmentPaperException;
import com.nacre.online_assesment.exception.POIException;
import com.nacre.online_assesment.form_bean.AssessmentPaperFormBean;
import com.nacre.online_assesment.form_bean.OptionsFromBean;
import com.nacre.online_assesment.form_bean.QuestionsFormBean;

/**
 * Servlet implementation class Test2
 */
/**
 * @author Krishna prakash
 * Action to read excel sheet and stored in session
 * @throws ServletException, IOException 
 */

@MultipartConfig
@WebServlet("/AssessmentPaperUploadAction.technical")
public class AssessmentPaperUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @throws ServletException 
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
		
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		    HttpSession session1=request.getSession(false);
	        PrintWriter pw=null;
	        if(session1.getAttribute("assmentId")!=null)
	        {    
	        Integer  assId=(Integer) (session1.getAttribute("assmentId"));
	       // session1.removeAttribute("assmentId");
	        System.out.println(assId+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            List<AssessmentPaperFormBean> assessmentFormBeanList=new ArrayList<AssessmentPaperFormBean>();
            //map to find duplicates in question
		    Map < String,List> questionDuplicateMap =new HashMap < String,List>(); 
			response.setContentType("text/html");
			Part p;
			try {
			    pw=response.getWriter();
				p = request.getPart("file");
				InputStream inputStream=p.getInputStream();
		        Workbook workbook = new XSSFWorkbook(inputStream);
		        Sheet firstSheet = workbook.getSheetAt(0);
		        // System.out.println("start "+columnIndexOfLevel);
		        Iterator<Row> iterator = firstSheet.rowIterator();//iterator();
	            int rowInd=0;
	            Integer levelInd=null;
		        while (iterator.hasNext()) 
		        {
		        	System.out.println("row no "+rowInd);
	    	        Map<String,String> optionDuplicateMap=new HashMap<String,String>();
		            Row nextRow = iterator.next();
		            Iterator<Cell> cellIterator = nextRow.cellIterator();
		            if(rowInd!=0)
		            {

		              assessmentFormBeanList.add(getCellDate(cellIterator,levelInd,questionDuplicateMap,optionDuplicateMap,workbook));
		              //System.out.println(assessmentFormBeanList);
		            
		            }else
		            {	
		            levelInd=getlevelInd(cellIterator);		
		            }        
		            rowInd++;
		            //System.out.println("level ind......."+levelInd);
		        }//ROWITERATOR
               			       
		       HttpSession session= request.getSession();
		       
		       session.setAttribute("assessmentPaper",assessmentFormBeanList); 
		       session.setAttribute("assessmentId",assId);  
		       System.out.println(assessmentFormBeanList); 
		     
		       for(Object li:assessmentFormBeanList)
		       {
		    	   AssessmentPaperFormBean l2=(AssessmentPaperFormBean)li;
		    	   System.out.println(l2.getQuestionsFormBean().getQuestion());
		    	   System.out.println("kkkk "+l2);
		       }
		       RequestDispatcher rd=request.getRequestDispatcher("./jsp/technical_team/QuestionEdit.jsp");
			   rd.forward(request, response);

			} 
			catch(POIException e)
			{
				pw.print("{\"error\":\"Not In Correct Format\"}");

			} 
			catch (ServletException e) 
			{
				pw.print("{\"error\":\"server is busy\"}");
				e.printStackTrace();
			} catch (IOException e) 
			{
				pw.print("{\"error\":\"Not In Correct Format\"}");
				e.printStackTrace();
			}
			catch(java.lang.IllegalStateException e)
			{
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/common/my_error_page.jsp");
				rd.include(request, response);
			}
			
			/*catch (Exception e) 
			{
			    RequestDispatcher rd=request.getRequestDispatcher("./jsp/technical_team/upload_assessment_paper.jsp");
				rd.include(request, response);
				e.printStackTrace();
				pw.print("{\"error\":\"Not In Correct Format\"}");

			}*/
          
	        }
	        else
	        {
	        	throw new AssessmentPaperException("No assessment such a assessment");
	        }   
	}

	private Integer getlevelInd(Iterator<Cell> cellIterator)
	{
        int columnIndexOfLevel=0;

		while (cellIterator.hasNext()) 
        {
            Cell cell = cellIterator.next();
            System.out.println("created OptionForm Bean");
        	System.out.println("hai");
        		switch (cell.getCellType()) 
                   {
                     case Cell.CELL_TYPE_STRING:
                	 String columnName=cell.getStringCellValue(); 
                	 if(columnName.equalsIgnoreCase("level"))
                	 {
                		 columnIndexOfLevel=cell.getColumnIndex();
                		 System.out.println("col index"+columnIndexOfLevel);
                	 }
                	 break;
                     default:
                     break;
                   }
        }	
        System.out.println("aa"+columnIndexOfLevel);	
		return columnIndexOfLevel;
		
	}
	
	
	@SuppressWarnings("unchecked")
	private AssessmentPaperFormBean getCellDate(Iterator<Cell> cellIterator,Integer levelInd,Map questionDuplicateMap,Map optionDuplicateMap,Workbook workbook )
	{
		int colInd=0;
		System.out.println("column index "+colInd);
        AssessmentPaperFormBean assessmentPaperBean=new AssessmentPaperFormBean();
        //setting assessmentId
    	QuestionsFormBean question=new QuestionsFormBean();
		List<OptionsFromBean> optionsList=new ArrayList<OptionsFromBean>();
		while (cellIterator.hasNext()) 
		{
			Cell cell = (Cell) cellIterator.next();
			cell.setCellType(Cell.CELL_TYPE_STRING);
			String cellvalue =cell.getStringCellValue();
	        String caseInsencitiveCellval=cellvalue.toLowerCase();
			
			 if(cell.getColumnIndex()==levelInd)
			{
				  if(cellvalue!=null)
				  {
				  System.out.println("level");
				  question.setLevel(cellvalue);
				  }
				
				
				
			}
			else if(cell.getColumnIndex()!=0)
			{
		    //creating object for OptionFromBean
			OptionsFromBean option = new  OptionsFromBean();
			//setting option to optioFormBean
			option.setOption(cellvalue);
			System.out.println("option "+cellvalue);
			//checking option is duplicate
			Boolean exists=isOptionsDuplicate(caseInsencitiveCellval,optionDuplicateMap);
			System.out.println("option duplicate "+exists);
			//setting duplicate 
			option.setIsDuplicate(exists);
			//adding options in each row to map
			optionDuplicateMap.put(caseInsencitiveCellval,colInd);
			//checking option is answer
		     Boolean optionIsAnswer=isAnswer(cell,workbook);
		     option.setIsAnswer(optionIsAnswer);
		     System.out.println("is answer "+optionIsAnswer);
			//adding option from bean to options list
			optionsList.add(option);
			

			}
			else
		    {
			
			question.setQuestion(cellvalue);
			System.out.println("question "+cellvalue);
			Boolean exists=isDuplicate(caseInsencitiveCellval,questionDuplicateMap);
			question.setIsDuplicate(exists);
			
			System.out.println("quest dup"+exists);
			questionDuplicateMap.put(caseInsencitiveCellval,colInd);
		    }
			
			colInd++;
			
		}
		
		assessmentPaperBean.setQuestionsFormBean(question);
		assessmentPaperBean.setOptionsFormBean(optionsList);
		//assessmentPaperBean.set
		return assessmentPaperBean;
	}
	private Boolean isDuplicate(String question,Map questionDuplicateMap) 
	{
		Boolean exists=false;
		 // Duplicate.questionIsDuplicate(excelMap, question);
    	System.out.println("nnnnnnnnnnnnnnnn"+question.toLowerCase());
         //string spaces
         /*Pattern pattern = Pattern.compile(" ");
         Pattern pat2=Pattern.compile("\\.");
         Pattern pat3=Pattern.compile(",");
         Matcher match3=pat3.matcher(quest);
         String m1=match3.toString();
         System.out.println(match3.replaceAll("")+" reg");
         Matcher matcher = pattern.matcher(m1);
         Matcher matcher1 = pat2.matcher(matcher.toString());
         System.out.println(matcher1.replaceAll("")+" reg");
         System.out.println(matcher.replaceAll("")+" reg");*/
        if(questionDuplicateMap.containsKey(question))
        {
        	Set s=questionDuplicateMap.keySet();
        	Iterator s2=s.iterator();
        	while(s2.hasNext())
        	{
        		System.out.println(s2.next()+"reg...........");
        	}
        	exists=true;
        }
		return exists;
		
	}
	private Boolean isOptionsDuplicate(String option,Map optionDuplicateMap ) 
	{
		Boolean exists=false;
		 // Duplicate.questionIsDuplicate(excelMap, question);
        if(optionDuplicateMap.containsKey(option))
        {
        	exists=true;
        }
		return exists;
		
	}
	private Boolean isAnswer(Cell cell ,Workbook workbook) 
	{
		
		Boolean exists=false;
		 // Duplicate.questionIsDuplicate(excelMap, question);
        if(cell!=null)
        {
        	Font font =  workbook.getFontAt(cell.getCellStyle().getFontIndex());
        	exists=font.getItalic();
        }
		return exists;
		
	}
	
	
}
