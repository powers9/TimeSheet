package org.timesheet.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="task_employee",
	joinColumns= {@JoinColumn(name="task_id")},
	inverseJoinColumns= {@JoinColumn(name="employee_id")})
	private List<Employee> assignedEmployees = new ArrayList<Employee>();
   @OneToOne
   @JoinColumn(name="manager_id")
	private Manager manager;
    private boolean completed;
    private String description;
 
    public Task(String description, Manager manager, Employee... employees) {
            this.description = description;
            this.manager = manager;
        assignedEmployees.addAll(Arrays.asList(employees));
        completed = false;
    }
 
    public Manager getManager() {
        return manager;
    }
 
    public List<Employee> getAssignedEmployees() {
        return assignedEmployees;
    }
 
    public void addEmployee(Employee e) {
        assignedEmployees.add(e);
    }
 
    public void removeEmployee(Employee e) {
        assignedEmployees.remove(e);
    }
 
    public void completeTask() {
        completed = true;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignedEmployees == null) ? 0 : assignedEmployees.hashCode());
		result = prime * result + (completed ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (assignedEmployees == null) {
			if (other.assignedEmployees != null)
				return false;
		} else if (!assignedEmployees.equals(other.assignedEmployees))
			return false;
		if (completed != other.completed)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		return true;
	}

	public void setAssignedEmployees(List<Employee> assignedEmployees) {
		this.assignedEmployees = assignedEmployees;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
    
    
}
