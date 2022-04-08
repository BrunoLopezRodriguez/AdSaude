package com.bruno.adsaude.model;

public class AsistidoFamiliar extends AbstractValueObject{

		private Integer idAsistido;
		private Integer idFamiliar;
		
		
		
		public AsistidoFamiliar() {
			
		}
		
		public Integer getIdAsistido() {
			return idAsistido;
		}
		public void setIdAsistido(Integer idAsistido) {
			this.idAsistido = idAsistido;
		}
		public Integer getIdFamiliar() {
			return idFamiliar;
		}
		public void setIdFamiliar(Integer idFamiliar) {
			this.idFamiliar = idFamiliar;
		}
		
		
		
}
