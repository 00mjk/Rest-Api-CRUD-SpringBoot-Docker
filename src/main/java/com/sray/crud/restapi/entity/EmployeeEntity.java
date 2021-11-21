package com.sray.crud.restapi.entity;


public class EmployeeEntity {
		private int id;
		private String name;
		public EmployeeEntity(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public EmployeeEntity() {
			super();
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "EmployeeEntity [id=" + id + ", name=" + name + "]";
		}
		
}
