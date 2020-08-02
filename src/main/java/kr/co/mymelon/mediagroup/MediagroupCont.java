package kr.co.mymelon.mediagroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Utility;

@Controller
public class MediagroupCont {
  
  @Autowired
  private MediagroupDAO dao;  
  
  public MediagroupCont() {
    System.out.println("---MediagroupCont() 객체 생성됨");  
  }  
  
  
  //결과확인
  //http://localhost:8090/mymelon/mediagroup/create.do
  
  
  @RequestMapping(value="/mediagroup/create.do", method=RequestMethod.GET)
  public String createForm() {
    return "mediagroup/createForm";
  }//createForm() end  
  
  
  @RequestMapping(value="/mediagroup/create.do", method=RequestMethod.POST)
  public ModelAndView createProc(MediagroupDTO dto) {
    ModelAndView mav=new ModelAndView();
    mav.setViewName("mediagroup/msgView");
    
    int cnt=dao.create(dto);
    if(cnt==0) {
      mav.addObject("msg1", "<p>미디어 그룹 등록 실패!!</p>");
      mav.addObject("img",  "<img src='../images/fail.png'>");
      mav.addObject("link1","<input type='button' value='다시시도' onclick='javascript:history.back()'>");
      mav.addObject("link2","<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
      
    }else {
      mav.addObject("msg1", "<p>미디어 그룹 등록 성공~~</p>");
      mav.addObject("img",  "<img src='../images/sound.png'>");
      mav.addObject("link1","<input type='button' value='계속등록' onclick='location.href=\"./create.do\"'>");
      mav.addObject("link2","<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
      
    }//if end
    
    return mav;
    
  }//createProc() end
  
  @RequestMapping("mediagroup/list.do")
  public ModelAndView list() {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("mediagroup/list");
	  mav.addObject("root", Utility.getRoot());
	  mav.addObject("list", dao.list());
	  return mav;
  }//list
  
  @RequestMapping(value="/mediagroup/delete.do", method=RequestMethod.GET)
  public ModelAndView deleteForm (MediagroupDTO dto) {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("mediagroup/deleteForm");
      mav.addObject("root", Utility.getRoot());
      mav.addObject("dto", dto);
      return mav;
  }//deleteForm 
 
  @RequestMapping(value="/mediagroup/delete.do", method=RequestMethod.POST)
  public ModelAndView deleteProc(MediagroupDTO dto) {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("mediagroup/msgView");
	  
	  int cnt=dao.delete(dto);
	    if(cnt==0) {
	      mav.addObject("msg1", "<p>미디어 그룹 삭제 실패!!</p>");
	      mav.addObject("img",  "<img src='../images/fail.png'>");
	      mav.addObject("link1","<input type='button' value='다시시도' onclick='javascript:history.back()'>");
	      mav.addObject("link2","<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
	      
	    }else {
	      mav.addObject("msg1", "<p>미디어 그룹 삭제 성공~~</p>");
	      mav.addObject("img",  "<img src='../images/sound.png'>");
	      mav.addObject("link1","<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
	      
	    }//if end

	    return mav;

  }//deleteProc
  
  @RequestMapping(value="/mediagroup/update.do", method=RequestMethod.GET)
  public ModelAndView updateForm (MediagroupDTO dto) {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("mediagroup/updateForm");
      mav.addObject("root", Utility.getRoot());
      mav.addObject("dto", dao.update(dto.getMediagroupno()));
      return mav;
  }//deleteForm 
 
  @RequestMapping(value="/mediagroup/update.do", method=RequestMethod.POST)
  public ModelAndView updateProc(MediagroupDTO dto) {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("mediagroup/msgView");
	  
	  int cnt=dao.updateproc(dto);
	    if(cnt==0) {
	      mav.addObject("msg1", "<p>미디어 그룹 수정 실패!!</p>");
	      mav.addObject("img",  "<img src='../images/fail.png'>");
	      mav.addObject("link1","<input type='button' value='다시시도' onclick='javascript:history.back()'>");
	      mav.addObject("link2","<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
	      
	    }else {
	    	
	      mav.addObject("msg1", "<p>미디어 그룹 수정 성공~~</p>");
	      mav.addObject("img",  "<img src='../images/sound.png'>");
	      mav.addObject("link1","<input type='button' value='그룹목록' onclick='location.href=\"./list.do\"'>");
	      
	    }//if end

	    return mav;

  }//deleteProc
  
  
  
  
}//class end
