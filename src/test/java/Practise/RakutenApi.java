package Practise;

public class RakutenApi {
	
	
	String API;
	String Description;
	String Auth;
	String HTTPS;
	String Cors;
	String Link;
	String Category;
	public RakutenApi(String aPI, String description, String auth, String hTTPS, String cors, String link,
			String category) {
		super();
		API = aPI;
		Description = description;
		Auth = auth;
		HTTPS = hTTPS;
		Cors = cors;
		Link = link;
		Category = category;
	}
	public RakutenApi() {
		
	}
	public String getAPI() {
		return API;
	}
	public String getDescription() {
		return Description;
	}
	public String getAuth() {
		return Auth;
	}
	public String getHTTPS() {
		return HTTPS;
	}
	public String getCors() {
		return Cors;
	}
	public String getLink() {
		return Link;
	}
	public String getCategory() {
		return Category;
	}
	public void setAPI(String aPI) {
		API = aPI;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void setAuth(String auth) {
		Auth = auth;
	}
	public void setHTTPS(String hTTPS) {
		HTTPS = hTTPS;
	}
	public void setCors(String cors) {
		Cors = cors;
	}
	public void setLink(String link) {
		Link = link;
	}
	public void setCategory(String category) {
		Category = category;
	}
	
	
}
