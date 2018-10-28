package cn.kabuto.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.kabuto.ssm.exception.CategoryException;
import cn.kabuto.ssm.exception.GoodsException;
import cn.kabuto.ssm.exception.ImgException;
import cn.kabuto.ssm.exception.UserException;
import cn.kabuto.ssm.pojo.Category;
import cn.kabuto.ssm.pojo.Goods;
import cn.kabuto.ssm.pojo.GoodsExtend;
import cn.kabuto.ssm.pojo.Img;
import cn.kabuto.ssm.pojo.User;
import cn.kabuto.ssm.service.CategoryService;
import cn.kabuto.ssm.service.GoodsService;
import cn.kabuto.ssm.service.ImgService;
import cn.kabuto.ssm.service.UserService;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ImgService imgService;
	/**
	 * 每次加载首页都会显示最新的商品信息
	 * 
	 * @return
	 * @throws GoodsException
	 */
	@RequestMapping("/homeGoods")
	public String homeGoods(Model model) throws GoodsException {
		
		//根据分类来查商品
		int cid = 7;
		for(int i = 1;i <=cid;i++){
			List<GoodsExtend> goodsExtendList = goodsService.selectByCidOrderByTime(i);
			int size = goodsExtendList.size();
			System.out.println(size);
			if(size<=5){
				String key = "cate"+i;
				model.addAttribute(key, goodsExtendList);
			}
			else if(size>5){
				GoodsExtend g1 =  goodsExtendList.get(0);
				GoodsExtend g2 =  goodsExtendList.get(1);
				GoodsExtend g3 =  goodsExtendList.get(2);
				GoodsExtend g4 =  goodsExtendList.get(3);
				GoodsExtend g5 =  goodsExtendList.get(4);
				
				List<GoodsExtend> list = new ArrayList<GoodsExtend>();
				list.add(g1);
				list.add(g2);
				list.add(g3);
				list.add(g4);
				list.add(g5);
				
				String key = "cate"+i;
				model.addAttribute(key, list);
			}
		}
		List<GoodsExtend> list0 = goodsService.selectAllOrderByTime();
		int size0 = list0.size();
		if(size0<=5){
			model.addAttribute("cate0", list0);
		}
		else if(size0>5){
			GoodsExtend g01 =  list0.get(0);
			GoodsExtend g02 =  list0.get(1);
			GoodsExtend g03 =  list0.get(2);
			GoodsExtend g04 =  list0.get(3);
			GoodsExtend g05 =  list0.get(4);
			
			List<GoodsExtend> list00 = new ArrayList<GoodsExtend>();
			list00.add(g01);
			list00.add(g02);
			list00.add(g03);
			list00.add(g04);
			list00.add(g05);
			
			model.addAttribute("cate0", list00);
		}
		return "pages/goods/homeGoods.jsp";
	}

	/**
	 * 查看分类下的商品信息
	 * 
	 * @param cid
	 * @param model
	 * @return
	 * @throws GoodsException
	 * @throws CategoryException
	 */
	@RequestMapping("/categoryGoods")
	public String categoryGoods(Integer cid, Model model)
			throws GoodsException, CategoryException {
		List<GoodsExtend> goodsExtendList = goodsService.selectByCidOrderByTime(cid);
//		List<Goods> list = goodsService.selectByCid(cid);
		Category category = categoryService.findByCid(cid);
		model.addAttribute("goodsExtendList", goodsExtendList);
		model.addAttribute("category", category);
		System.out.println(category.getCname());
		return "pages/goods/catelogGoods.jsp";
	}

	/**
	 * 发布商品
	 * 
	 * @param model
	 * @param goods
	 * @param myfile
	 * @param session
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws GoodsException
	 * @throws UserException
	 * @throws ImgException 
	 */
	@RequestMapping("/uploadGoods")
	public String uploadGoods(Goods goods,Model model,@RequestParam("myfiles") MultipartFile myfiles[],HttpSession session) throws UserException, GoodsException, IllegalStateException, IOException, ImgException{
		User user = (User) session.getAttribute("user");
		User u = userService.findByname(user.getUsername());
		Integer uid = u.getUid();
		goods.setUid(uid);
		
		goodsService.addGoods(goods);
		List<String> filesName = this.uploadFlieList(myfiles);
		Integer gid = goods.getGid();
		for(String imgurl:filesName){
			System.out.println(imgurl);
			Img img = new Img();
			img.setGid(gid);
			img.setImgurl(imgurl);
			imgService.addImg(img);	
		}
		return "pages/user/success.jsp";
	}
	
	

	/**
	 * 跳转编辑商品
	 * 
	 * @param gid
	 * @param model
	 * @return
	 * @throws GoodsException
	 */
	@RequestMapping("/editGoods")
	public String editGoods(Integer gid, Model model) throws GoodsException {
		GoodsExtend goodsExtend = goodsService.selectByGid(gid);
		model.addAttribute("goodsExtend", goodsExtend);
		return "pages/goods/editGoods.jsp";

	}

	/**
	 * 编辑商品
	 * 
	 * @param goods
	 * @param session
	 * @param myfile
	 * @return
	 * @throws GoodsException
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	
	@RequestMapping("/editGoodsSubmit")
	public String editGoodsSubmit(Goods goods, HttpSession session) throws GoodsException{
		goods.setFlashtime(new Date());
		User user = (User) session.getAttribute("user");
		goods.setUid(user.getUid());
		System.out.println(goods.getStarttime());
		System.out.println(goods);
		goodsService.editGoodsSubmit(goods);
		return "pages/user/success.jsp";

	}

	/**
	 * 删除商品
	 * 
	 * @param gid
	 * @return
	 * @throws GoodsException
	 */
	@RequestMapping("/deleteGoods")
	public String deleteGoods(Integer gid) throws GoodsException {
		goodsService.deleteGoods(gid);
		return "pages/user/success.jsp";
	}

	@RequestMapping("/searchGoods")
	public String searchGoods(String str, Model model) throws GoodsException {
		List<GoodsExtend> goodsExtendList = goodsService.selectByGname(str);
		model.addAttribute("goodsExtendList", goodsExtendList);
		return "pages/goods/searchGoods.jsp";
	}

	/**
	 * 显示商品细节
	 * 
	 * @param gid
	 * @param model
	 * @return
	 * @throws GoodsException
	 * @throws UserException 
	 */
	@RequestMapping("/detailGoods")
	public String detailGoods(Integer gid, Model model) throws GoodsException, UserException {
		GoodsExtend goodsExtend = goodsService.selectByGid(gid);
		Integer uid = goodsExtend.getUid();
		User saler = userService.findByUid(uid);
		model.addAttribute("goodsExtend", goodsExtend);
		model.addAttribute("saler", saler);
		return "pages/goods/detailGoods.jsp";
	}

	/**
	 * 多图片上传测试
	 * @param files
	 * @param model
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
//	@RequestMapping("/uploadFile")
//	public String  uploadFile(@RequestParam("files") MultipartFile files[],Model model) throws IllegalStateException, IOException {
//		List<String>newFileNames=this.uploadFlieList(files); 
//		for (String newFileName:newFileNames){  
//            System.out.println("newfile"+newFileName);  
//       } 
//		return "index.jsp";
//	}
	
	/**
	 * 图片上传用方法
	 * @param files
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public List<String> uploadFlieList(MultipartFile files[]) throws IllegalStateException, IOException{
		List<String> newFlieNames = new ArrayList<String>();
		for(MultipartFile file:files){
			//获得原来的名称
			String originalFilename = file.getOriginalFilename();
			String newFileName=null; 
			if (file != null && originalFilename != null
					&& originalFilename.length() > 0) {
				String path = "C:\\develop\\upload\\temp\\";
				// 新的名称
				newFileName = UUID.randomUUID()
						+ originalFilename.substring(originalFilename
								.lastIndexOf("."));
				File newFile = new File(path + newFileName);
				// 写入数据
				file.transferTo(newFile);
				// goods.setPicture(fileName);
				newFlieNames.add(newFileName); 
			}
		}
		return newFlieNames;
	}
	
	
	/**
	 * 测试GoodsImgMap
	 * @param model
	 * @return
	 * @throws GoodsException
	 */
	@RequestMapping("/GoodsExtendTest")
	public String GoodsExtendTest(Model model) throws GoodsException{
		GoodsExtend goodsExtend = goodsService.selectByGid(3);
		model.addAttribute("goodsExtend", goodsExtend);
//		List<GoodsExtend> list = goodsService.selectByCidOrderByTime(1);
//		System.out.println(list.size());
//		model.addAttribute("list", list);
//		for(GoodsExtend extend:list){
//			for(Img img:extend.getImgList()){
//				System.out.println(img.getImgurl());
//			}
//		}
		return "goodsextendtest.jsp";
	}

}
