(function($){
	function initValidator($form){
		var opts = $form.data("jxtvValidator").options;
		if(!opts.showStar)return;
		/*是否加入*符号，代表必须填写的*/
		$form.find("[jrequired]").each(function(){
			var $text = $('<span class="jxtv-ui-required" '+opts.floatArrow+'>*</span>');
			var trueMsg = $(this).attr("jrequired");
			if(trueMsg=='required' || trueMsg=='true'){
				if($(this).parent().prev().hasClass("tmui-v-label") || $(this).parent().prev().hasClass("tmui-label")){
					$text.prependTo($(this).parent().prev().children().end());	
				}else{
					if(isNotEmpty($(this).next().html())){
						$(this).next().before($text);
					}else{
						$(this).before($text);
					}
				}
			}
		});
	};

	
	/*事件绑定*/
	function bindEvents($target){
		$.fn.tmValidator.methods._init($target);
		$target.find(".jxtv-submit").click(function(){
			errorMsgArr=[];
			var opts = $target.data("jxtvValidator").options;
			var $submit = $(this);	
			/*来子后台的验证*/
			if(jxtvSubmitValidator($target)){
				if(opts.validator(opts) && opts.timerSuccess(opts)){
					opts.params = typeof opts.params =='string' ? $target.serialize() :opts.params;
					if(opts.ajax){
						opts.callback(opts,$target,$submit);
					}else{
						$(this).parents("form").submit();
					}
				}
			}else{
				backTipInput($target);
				opts.after(opts,$submit,errorMsgArr,$target);
			}	
		});
	}
	
	function tm_ajax_validator($form){
		$form.find(".tmui_vajax").blur(function(){
			var flag = true;
			var $this = $(this);
			var ajaxUrl = $this.attr("url");
			var field = $this.attr("name");
			var value = $this.val();
			var message = $this.attr("message");
			var params = "{'"+field+"':'"+value+"'}";
			var ep = eval("("+params+")");
			$.ajax({
				type:"post",
				url:ajaxUrl,
				data:ep,
				success:function(data){
					if(data.result=="success"){
						
					}else{
						tmLoading(message,true,1);
					}
				}
			});
		});
		
	}
	
	function jxtvStartFocus($target){
		$target.focus();
	};

	/*submit提交验证*/
	function jxtvSubmitValidator($form){
		var isSubmit = true;
		var opts = $form.data("jxtvValidator").options;
		if(opts.start(opts)){
			clearTipInput($form);
			$form.find("[jrequired],[jvalidator],[min],[max],[reg],[regMsg],[jlength],[to],.jxtv-input").each(function() {
				var submit = jxtvValidator($(this));
				if (!submit) {
					isSubmit = false;
				}
			});
			return isSubmit;
		}else{
			return false;
		}
	}
	
	function clearTipInput($form){
		$form.find("*").each(function(){
			if($(this).attr("tip") == $(this).val()){
				$(this).val("");
			}
		})
	};

	
	function backTipInput($form){
		/*$form.find("*").each(function(){
			if(isEmpty($(this).val())){
				$(this).val($(this).attr("tip"));
			}
		})*/
	};


	/*这里这个$this是代表文本框本身不是整个$form对象*/
	function jxtvValidator($this){
		//验证是否必填字段
		var isPass = true;
		var requiredText = $this.attr("jrequired");
		var value = $this.val();
		
		if(!jxtvNumbering($this)){
			return false;
		};
		
		if(requiredText!=undefined && (requiredText=='required' || requiredText=='true')){
			if(!jxtvRequired($this)){
				return false;
			}
		}
		
		if(isNotEmpty(value)){
			if(isNotEmpty($this.attr("reg")) && isNotEmpty($this.attr("regMsg"))){
				if(!jxtvValidate($this,$this.attr("reg"),$this.attr("regMsg"))){
					return false;
				}
			};
			
			if(!jxtvMin($this)){
				return false;
			};
			
			if(!jxtvLength($this)){
				return false;
			};
	
			if(!jxtvValidatePassword($this)){
				return   false;
			};
			
			if(!jxtvFieldValidator($this)){
				return  false;
			}
		}
		return isPass;
	}


	/*验证器验证*/
	function jxtvFieldValidator($this){
		var isPass = true;	
		var validator = $this.attr("jvalidator");
		var currentVal = $this.val();
		if(currentVal != "" && currentVal.length >0){
			if($.fn.tmValidator.methods[validator]!=undefined){
				if(!$.fn.tmValidator.methods[validator]($this)){
					isPass = false;
				}
			}
		}
		return isPass;
	}
	
	/*密码验证*/
	function jxtvValidatePassword($this) {
		var isPass = true;
		var oldPassword = $this.attr("to");
		if(isNotEmpty(oldPassword)){
			var $oldObj = $("#"+oldPassword);
			/*确认密码值*/
			var currentPasswordVal = $this.val();
			/*当前的值*/
			var oldPasswordVal = $oldObj.val();
			var oldPwdText =  $.fn.tmValidator.methods.getPrevLabel($oldObj);
			var currentPwdText =  $.fn.tmValidator.methods.getPrevLabel($this);
			if(oldPasswordVal!="" && currentPasswordVal !="" && currentPasswordVal != oldPasswordVal){
				$.fn.tmValidator.methods.errorMessage($this,"两次输入的密码不一致!");
				isPass = false;
			}else{
				$.fn.tmValidator.methods.showMessage($oldObj,"输入正确");
				$.fn.tmValidator.methods.showMessage($this,"输入正确");
			}
		}
		return isPass;
	};


	/*长度验证*/
	function jxtvLength($this){
		var max = $this.attr("jlength");
		var value = $this.val();
		var isSubmit = true;
		var text = $.fn.tmValidator.methods.getPrevLabel($this);
		if(isNotEmpty(max) && !isNaN(max) && isNotEmpty(value)){
			if(value.length > max){
				$.fn.tmValidator.methods.errorMessage($this,text+"：长度不能超过"+max+"位!");
				isSubmit =  false;
			}else{
				$.fn.tmValidator.methods.showMessage($this,"输入正确");
			}
		}
		return isSubmit;
	}

	function jxtvMin($this){
		var min = $this.attr("min");
		var value = $this.val();
		var isSubmit = true;
		var text = $.fn.tmValidator.methods.getPrevLabel($this);
		if(isNotEmpty(min) && !isNaN(min && isNotEmpty(value))){
			if(value.length <min){
				$.fn.tmValidator.methods.errorMessage($this,text+"：长度不能少于"+min+"位!");
				isSubmit =  false;
			}else{
				$.fn.tmValidator.methods.showMessage($this,"输入正确");
			}
		}
		return isSubmit;
	}
	
	function jxtvNumbering($this){
		var num = $this.attr("number");
		var value = $this.val();
		var isSubmit = true;
		var text = $.fn.tmValidator.methods.getPrevLabel($this);
		if(isNotEmpty(num) && !isNaN(num && isNotEmpty(value))){
			if(value * 1 < num*1){
				$.fn.tmValidator.methods.errorMessage($this,text+"：不能少于"+num+"个!");
				isSubmit =  false;
			}else{
				$.fn.tmValidator.methods.showMessage($this,"输入正确");
			}
		}
		return isSubmit;
	}

	// 非空校验
	function jxtvRequired($target) {
		var text = $.fn.tmValidator.methods.getPrevLabel($target);
//		if(isEmpty(text))text = "";
//		var msgtext = text+"不能为空";
//		if(isNotEmpty(text))msgtext = "{"+text.replace(/[*|:|]+/,'').replace("：","")+"}不能为空";
//		return jxtvValidate($target, /[^(^\s*)|(\s*$)]/, msgtext);
		var value = $target.val();
		var isSubmit = true;
		if(isEmpty(value)){
			//$target.val($target.attr("tip"));
			$.fn.tmValidator.methods.errorMessage($target,text+"：不允许为空!");
			isSubmit =  false;
		}else{
			$.fn.tmValidator.methods.showMessage($target,"输入正确");
		}
		return isSubmit;
	}

	/*验证器*/
	function jxtvValidate($this,regex,msg){
		/*获取目标value*/
		var value = $this.val();
		if(isEmpty(value))value = $this.text();
		if(!eval(regex).test(value)){
			$.fn.tmValidator.methods.errorMessage($this,msg);
			return false;
		}else{
			$.fn.tmValidator.methods.showMessage($this,msg);
			return true;
		}
	}
	
	function jxtvTipValidator($this){
		var value = $this.val();
		var tip = $this.attr("tip");
		if(isEmpty(value))value = $this.text();
		if(isEmpty(value)){
			$.fn.tmValidator.methods.errorMessage($this,"{"+tip+"}");
			return false;
		}
		if(isNotEmpty(value) && value == tip){
			$.fn.tmValidator.methods.errorMessage($this,"{"+tip+"}");
			return false;
		}
		$.fn.tmValidator.methods.showMessage($this,"输入正确");
		return true;
	}

	/*验证插件相关*/
	$.fn.tmValidator = function(options){
		this.each(function(){
			var $form = $(this);
			var  opts = null;
			var cache = $.data($form,"jxtvValidator");
			if(cache){
				opts = $.extend(cache.options, options);
				cache.options = opts;
			}else{
				var opts = $.extend({},$.fn.tmValidator.defaults,$.fn.tmValidator.parseOptions($form),$.fn.tmValidator.methods,options);
				$form.data("jxtvValidator",{options:opts});			
				initValidator($form);
				bindEvents($form);
				tm_ajax_validator($form);
			}
		});	
	};
	

	$.fn.tmValidator.parseOptions = function(target) {
		var $target = $(target);
		return {
			required : $target.attr("jrequired"),
			reg : $target.attr("reg"),
			tip : $target.attr("tip"),
			url : $target.attr("url")
		}
	};
	

	$.fn.tmValidator.defaults ={
		ajax:false,	
		required:"false",//是否必填
		focus:"jxtv-focus",//选中的文本框定义的className
		arrow:"left",//显示风格为tip的方向，还有一种是top
		hoverStatus:false,//是否鼠标hover事件的验证
		tipTextColor:"#333",
		show:"show",//显示的风格，两种风格tip
		showText:"false",//控制显示前面的名称
		style:'error-left-style',
		showStar:true,/*是否显示红星*/
		focusFirst:false,
		floatArrow:"",
		time:"",
		tipMessage:true,
		showStyle:true,
		border:"",
		
		/*事件的处理对象*/
		start:function(opts){return true;},/*提交之前触发的处理事件放在这里方法里面*/
		validator:function(opts){return true;},/*提交之前触发的处理事件放在这里方法里面*/
		after:function(opts,$submitBtn){},/*验证失败的时候出现*/
		callback : function(opts,$this,$submit){
			
		},
		timerSuccess:function(opts){
			return true;
		}
	}
	
	var valiatorTimer = null;
	var errorMsgArr = [];
	$.fn.tmValidator.methods ={
		email:function ($this){
			return jxtvEmail($this);
		},
		date:function($this){
			return jxtvDate($this);
		},
		ip:function($this){
			return jxtvIp($this);
		},
		password:function($this){
			return jxtvPassword($this);
		},
		idCard : function($this){
			return jxtvIDCard($this);
		},
		chinese:function($this){
			return jxtvChinese($this);
		},
		cn:function($this){
			return jxtvChinese($this);
		},
		integer:function($this){
			return jxtvInteger($this);
		},
		number:function($this){
			return jxtvInteger($this);
		},
		num:function($this){
			return jxtvInteger($this);
		},
		money:function($this){
			return jxtvMoney($this);			
		},
		filter:function($this){
			return jxtvFilterCharactor($this);
		},
		username:function($this){
			return jxtvUsername($this);
		},
		phone:function($this){
			return jxtvTelephone($this);
		},
		telephone:function($this){
			return jxtvTelephoneOrMoblie($this);
		},
		mobile:function($this){
			return jxtvMobile($this);
		},
		nickname:function($this){
			return jxtvNickname($this);
		},
		english :function($this){
			return jxtvEnglish($this);
		},
		vurl :function($this){
			return jxtvURL($this);
		},
		qq :function($this){
			return jxtvQQ($this);
		},
		yy :function($this){
			return jxtvYY($this);
		},
		url2 :function($this){
			return jxtvURL2($this);
		},
		filter :function($this){
			return jxtvFilterCharactor($this);
		},
		code :function($this){
			return jxtvCode($this);
		},
		showMessage:function($this,msg){
			var opts = $this.parents("form").data("jxtvValidator").options;
			$this.css("border","1px solid #ccc");
			if(opts.showStyle){	
				$this.next(".tmui-right-style").remove();
				$this.next(".tmui-error-style").remove();
				if(isNotEmpty(opts.floatArrow)){
					$this.after("<div class='tmui-right-style' "+opts.floatArrow+"><span title='"+msg+"' class='right-style'></span></div>");
				}else{
					$this.after("<div class='tmui-right-style'><span title='"+msg+"' class='right-style'></span></span>");
				}
			}
			//errorMsgArr.push(msg);
			if(isNotEmpty(opts.time)){
				this.timer($this,opts);
			}
		},
		errorMessage:function($this,msg){
			var opts = $this.parents("form").data("jxtvValidator").options;
			if(opts.border){
				$this.css("border","1px solid red");
			}
			if(opts.showStyle){	
				$this.next(".tmui-right-style").remove();
				$this.next(".tmui-error-style").remove();
				if(isNotEmpty(opts.floatArrow)){
					$this.after("<div class='tmui-error-style' "+opts.floatArrow+"><span class='error-style' title='"+msg+"'></span><span title='"+msg+"' class='tm-vd-message' style='color:red;'>"+msg+"</span></div>");
				}else{
					$this.after("<div class='tmui-error-style'><span class='error-style' title='"+msg+"'></span><span class='tm-vd-message' title='"+msg+"' style='color:red;'>"+msg+"</span></div>");
				}
			}
			var text = $.fn.tmValidator.methods.getPrevLabel($this);
			errorMsgArr.push(msg);
			if(isNotEmpty(opts.time)){
				this.timer($this,opts);
			}
			if(!opts.tipMessage){
				$(".tm-vd-message").hide();
			}
			
			
		},
		timer:function($this,opts){
			valiatorTimer = setTimeout(function(){
				$this.next(".tmui-right-style").remove();
				$this.next(".tmui-error-style").remove();
				$this.css("border","1px solid #ccc");
				opts.timerSuccess(opts);
			},opts.time*1000);
			
			
		},
		
		getPrevLabel:function($this){
			var msg = $this.prev(".tmui-label").text().replace(/[\*|：]*/ig,'');
			if(isEmpty(msg)){
				msg = $this.attr("title");
			}
			if(isEmpty(msg)){
				msg = $this.attr("tip");
			}
			return msg ;
		},
		
		_init:function($target){
			var opts = $target.data("jxtvValidator").options;
			/*默认第一个input type=text 框选中*/
			if(opts.focusFirst)$target.find("input[type='text']:first").addClass("jxtv-focus").focus();	
			/*为每个文本框绑定相应的事件*/
			if(opts.show=='tip')hoverFlag="true";
			var $vthis = $target.find("[reg],[regMsg],[jlength],[jrequired],[min],[max],[jvalidator],[to],.jxtv-input");
			
			$vthis.off("blur").on("blur",function(){
				return jxtvValidator($(this));
			});
			
			if(opts.hoverStatus){
				$vthis.hover(function(){
					
				},function(){
					return jxtvValidator($(this));
				});
			}
		}
	};
	// ^[1-9]\d*$　 　 //匹配正整数 
	//^-[1-9]\d*$ 　 //匹配负整数 
	//^-?[1-9]\d*$　　 //匹配整数 
	//^[1-9]\d*|0$　 //匹配非负整数（正整数 + 0） 
	//^-[1-9]\d*|0$　　 //匹配非正整数（负整数 + 0） 
	//^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$　　 //匹配正浮点数 
	//^-([1-9]\d*\.\d*|0\.\d*[1-9]\d*)$　 //匹配负浮点数 
	//^-?([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$　 //匹配浮点数 
	//^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$　　 //匹配非负浮点数（正浮点数 + 0） 
	//^(-([1-9]\d*\.\d*|0\.\d*[1-9]\d*))|0?\.0+|0$　　//匹配非正浮点数（负浮点数 + 0） 
//评注：处理大量数据时有用，具体应用时注意修正  
	//filter money int num integer chinese blank telephone phone email username password date ip ,english,url,mobile,url url2 code
	
	
	/*URL*/
	function jxtvURL($target) {
		return  jxtvValidate($target, /^(http\:\/\/)?([\w.]+)(\/[\w-   \.\/\?%&=]*)?$/gi, "链接地址不正确!");
	};
	
	function jxtvURL2($target) {
		return  jxtvValidate($target, /^[a-zA-z]+:\/\/(\w+(-\w+)*)(\.(\w+(-\w+)*))*(\?\S*)?$/gi,"链接地址不正确!");
	};
	
	/*邮政编码*/
	function jxtvCode($target) {
		return  jxtvValidate($target, /^[1-9]\d{5}(?!\d)$/, "邮编不正确!");
	};
	
	/*手机*/
	function jxtvMobile($target) {
		return  jxtvValidate($target, /^(13|15|18)\d{9}$/, "手机号码不正确!");
	};
	
	/*手机*/
	function jxtvTelephoneOrMoblie($target) {
		return  jxtvValidate($target, /(^(\d{3,4}-)?\d{7,8})$|((13|15|18)\d{9})$/, "座机或手机号码不正确!");
	};
	/*
	function jxtvQQ($target){
		return  jxtvValidate($target, /^[1-9][0-9]{4,}$/, "QQ号码不正确!");
	}*/
	
	function jxtvIDCard($target){
		return  jxtvValidate($target, /^\d{15}|\d{18}$/, "身份证号码不正确[15或者18位]!");
	}
	
	/*固定电话号码*/
	function jxtvTelephone($target) {
		return  jxtvValidate($target, /^\d{3}-\d{8}|\d{4}-\d{7}$/,"电话号码不正确!");
	};
	
	/*邮箱*/
	function jxtvEmail($target) {
		return  jxtvValidate($target, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,"邮箱格式不正确");
	};
	
	/*验证密码*/
	function jxtvPassword($target) {
		return jxtvValidate($target, /^[\dA-Za-z(!@#$%&)]{6,16}$/, "(数字,字母,下划线)[6-16位]");
	};
	
	/*验证用户名*/
	function jxtvUsername($target){
		return  jxtvValidate($target, /^[a-zA-Z]{1}[a-zA-Z0-9_]{3,16}$/ , "账号必须以字母开头,数字,下划线3-16位");
		//return  jxtvValidate($target, /(^[\w.\-]+@(?:[a-z0-9]+(?:-[a-z0-9]+)*\.)+[a-z]{2,6}$)|(^1[3|4|5|8]\d{9}$)|(^[a-zA-Z]{1}[a-zA-Z0-9_]{3,16}$)|(^\d{3,}$)|(^\++\d{2,}$)/ , "账号必须以字母开头,数字,下划线4-16位或者使用邮箱");
		//return  jxtvValidate($target, /(^[\w.\-]+@(?:[a-z0-9]+(?:-[a-z0-9]+)*\.)+[a-z]{2,6}$)|(^1[3|4|5|8]\d{9}$)|(^[a-zA-Z]{1}[a-zA-Z0-9_]{3,16}$)|(^\d{3,}$)|(^\++\d{2,}$)/ , "账号必须以字母开头,数字,下划线4-16位或者使用邮箱");
	}
	/*昵称*/
	function jxtvNickname($target){
		//return  jxtvValidate($target, /^([\u4e00-\u9fa5]{2,7})|([A-Za-z0-9 ]{4,14})$/ , "昵称必须是中文(2-7)位,数字字母(4-14)位");
		return  jxtvValidate($target, /^[\u4e00-\u9fa5A-Za-z0-9-_]{2,14}$/ , "昵称必须英文，数字，下划线(2-14)位");
		
	}
	
	function jxtvDate($target) {
		return jxtvValidate($target, /^(((([0-9]{2}(([2468][048])|([02468][48])|([13579][26])))|((([02468][048])|([13579][26]))(00)))(-)(2|02)(-)(([0]?[1-9])|([1-2][0-9])))|((([0-9]{2}([02468][1235679])|([13579][0133445789]))|((([02468][1235679])|([13579][01345789]))(00)))(-)(2|02)(-)(([0]?[1-9])|([1][0-9])|([2][0-8])))|(([0-9]{4})(-)(((([0]?(1|3|5|7|8))|(10|12))(-)(([0]?[1-9])|([1-2][0-9])|30|31))|(((([0]?(4|6))|11))(-)(([0]?[1-9])|([1-2][0-9])|30)))))(\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9]))?$/, "日期格式不正确");
	};

	/*IP*/
	function jxtvIp($target) {
		return jxtvValidate($target, /^\d+.\d+.\d+.\d+$/, "IP格式不正确,如:[127.0.0.1]");
	}
	
	/*QQ*/
	function jxtvQQ($target) {
		return jxtvValidate($target, /^\d{5,12}$/, "QQ号码不正确");
	}
	
	function jxtvYY($target) {
		return jxtvValidate($target, /^[a-z]+[a-z0-9]{3,15}$/g, "只允许小写英文字母和数字，必须是字母开头，4-16个字符");
	}
	
	/*验证密码*/
	function jxtvPassword($target) {
		return jxtvValidate($target, /^[\dA-Za-z(!@#$%&)]{6,16}$/, "(数字,字母,下划线)[6-16位]");
	};

	/*验证中文*/
	function jxtvChinese($target) {
		/*^\x00-\xff*/	
		return jxtvValidate($target, /^[\u4e00-\u9fa5]+$/, "请输入中文字符");
	};
	
	/*验证纯字母*/
	function jxtvEnglish($target) {
		/*^\x00-\xff*/	
		return jxtvValidate($target, /^[a-zA-Z]+$/, "请输入英文字符");
	};
	
	
	
	/*匹配空白行*/
	function jxtvBlank($target){
		return jxtvValidator($target,/^\n\s*\r$/, "是空白行")
	}

	/*验证正整数*/
	function jxtvInteger($target) {
		return jxtvValidate($target, /^[-\+]?\d+$/, "只允许输入整数");
	};
	
	function jxtvMoney($target){
		return jxtvValidate($target, /(^[-+]?[1-9]\d*(\.\d{1,4})?$)|(^[-+]?[0]{1}(\.\d{1,4})?$)/, "金额格式不正确");
	};
		
	/*验证非法字符*/
	function jxtvFilterCharactor($target) {
		return jxtvValidate($target, /[\\~\[\]`!@#\$\%\^&\*\(\)-\+=\{\}:;<>,\.\?\|\"\/！￥·……（）——【】、；。，“‘？》《]*/ig,  "存在非法字符");
	};

	/*验证插件相关-end*/
})(jQuery)