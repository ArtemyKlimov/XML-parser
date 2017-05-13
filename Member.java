import java.util.ArrayList;
import java.util.TreeSet;

public class Member implements Comparable<Member> {
	private String name;
	private ArrayList<Role> roles;
	
	public Member(String name, Role role) {
		this.name = name;
		this.roles = new ArrayList();	
		roles.add(role);
	}
		
	public static class Role {
		private String roleName;
		private String projectName;
		
		public Role(String roleName, String projectName) {
			this.roleName = roleName;
			this.projectName = projectName;
		}
		
		public String getRole() {
			return roleName;
		}
		
		public String getProjectName() {
			return projectName;
		}
		@Override
		public String toString() {
			return "role = " + roleName + "; project = "+ projectName;
		}
	}
	@Override
	public int compareTo(Member member) {
		return this.getName().compareTo(member.getName());
	}
	
	public ArrayList<Role> getRoles() {
		return roles;
	}
	
	public String getName() {
		return name;
	}
	
	public void addRole(String name, String project) {
		roles.add(new Role(name, project));
	}
	
	public void addRole(Role role) {
		roles.add(role);
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Role r : roles) {
			str.append("name = " +name +"; "+ r);
			str.append("\n");
		};
		return str.toString();
	}
}
