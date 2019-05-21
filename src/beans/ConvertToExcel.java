package beans;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class ConvertToExcel {
	
	
	public static void main(String[] args) {
		
		
		Configuration cfg=new Configuration();
		cfg.addResource("DBMail.hbm.xml");
		SessionFactory fact=cfg.buildSessionFactory();
		Session session=fact.openSession();
		
		Query query=session.createQuery("from Department");
		List<Department> dept=query.list();
		try{
		
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		for(Department d:dept){
			
			
			
			XSSFSheet sheet=workbook.createSheet(d.getType());
			
			
			int i=0;
			
			for(Employee e:d.getS()){
				
				Row row=sheet.createRow(i++);
				
				Cell cell=null;
				
				for(int j=0;j<4;j++){
					
					cell=row.createCell(j);
					
					if(j==0)
					{ 
						cell.setCellValue(e.getId());
						
					}
					if(j==1)
					{
						cell.setCellValue(e.getName());
					}
					if(j==2)
					{
						cell.setCellValue(e.getCity());
					}
					if(j==3)
					{
						cell.setCellValue(e.getSalary());
					}
					sheet.autoSizeColumn(j);
					
				}
				
			}
			
			
			
		}
		
		FileOutputStream stream=new FileOutputStream("E:/java and sql/APACHE POI/Dept-Emp DB/Database.xlsx");
		workbook.write(stream);
		workbook.close();
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Done");
		
	}

}
