$('#modalExcluir').on('show.bs.modal', function(event){
	
	var button =$(event.relatedTarget);
	
	var codigoTitulo = button.data('id');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.attr('action');
	if(!action.endsWith('/')){
		action +='/';
	}
	form.attr('action', action + codigoTitulo);
	
});