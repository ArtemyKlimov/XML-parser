import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Member implements Comparable<Member> {
	private String name;
	private TreeSet<Role> roles;
	
	public Member(String name, Role role) {
		this.name = name;
		this.roles = new TreeSet();	
		roles.add(role);
	}
	
	Comparator<Role> comparator = new Comparator<Role>() {
		@Override
		public int compare(Role r1, Role r2) {
			int prohectsComparing = r1.projectName.compareTo(r2.projectName);
			if (prohectsComparing != 0)
				return prohectsComparing;
			return r1.roleName.compareTo(r2.roleName);
		}
	};
		
	public static class Role implements Comparable<Member.Role>{
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

		@Override
		public int compareTo(Role o) {
			int n = projectName.compareTo(o.projectName);
			if(n != 0)
				return n;
			return roleName.compareTo(o.roleName);
		}
	}
	
	@Override
	public int compareTo(Member member) {
		return this.getName().compareTo(member.getName());
	}
	
	public TreeSet<Role> getRoles() {
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
