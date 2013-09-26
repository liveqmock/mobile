(function($) {
	var _log = $.youi.log;
	/**
	 *  accordion 组件
	 * @author  zhouyi
	 * @version 1.0.0
	 * @date 2011-03-18
	 */
	
	var _QUOTE = "_QUOTE_";
	
	$.widget("youi.xeditor", $.extend({
		_init:function(){
			this.element.addClass('youi-xeditor');
		},
		
		loadXml:function(url,params){
			var self = this;
			$.youi.ajaxUtil.ajax({
				url:url,
				data:params,
				success:function(result){
					self.parseXml(result.record.html);
				}
			});
		},
		
		parseXml:function(xmlStr){
			var htmls = [];
			xmlStr = xmlStr.replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/" "/g,'""').replace(/"/g, _QUOTE);
//		    .replace(/>/g, '&gt;')
			var lines = xmlStr.split('\n');
			
			for(var i=0;i<lines.length;i++){
				//if(!lines[i])continue;
				var level = this._parseLevel(lines[i]);
				htmls.push('<div class="xml-line node-level-'+level+'">');
				//htmls.push('<span class="line-index">'+(i+1)+'<span>');
				htmls.push('<span style="padding-left:'+(level*16)+'px;"  class="line-padding"> <span>');
				//行解析
				htmls.push(this._parseLine(lines[i]));
				htmls.push('</div>');
			}
			this.element.html(htmls.join(''));
		},
		
		_parseLevel:function(line){
			var level = 0;
			if(line.indexOf(' ')==0){
				level = line.split('&')[0].length/2;
			}
			return level;
		},
		
		_parseLine:function(line){
			if(!line)return '';
			var results = [];
			
			//<startEvent id="startevent1" activiti:formKey="start Vacation Request" name="Start"/>
			var splits = $.trim(line).split(' ');
			for(var i=0;i<splits.length;i++){
				var term = splits[i];
				if(term.indexOf('=')!=-1){
					term = term.replace(/=_QUOTE_/g, '</span>="<span class="attr-value">')
					.replace(/_QUOTE_/g,'</span>"');
					results.push('<span class="attr-key">'+term);
				}else{
					results.push(term.replace(/_QUOTE_/g,'</span>"'));
				}
			}
			return results.join(' ');
		},
		
		destroy:function(){
			$.Widget.prototype.destroy.apply(this, arguments);
		}
	}));
	
	$.extend($.youi.xeditor,{
		version: "1.0.0",
		defaults:{
			
		}
	});
})(jQuery);