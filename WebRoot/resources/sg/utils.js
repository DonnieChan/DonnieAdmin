	
/*动画执行开始*/
if (!window.requestAnimationFrame) {
  window.requestAnimationFrame = (window.webkitRequestAnimationFrame ||
                                  window.mozRequestAnimationFrame ||
                                  window.msRequestAnimationFrame ||
                                  window.oRequestAnimationFrame ||
                                  function (callback) {
                                    return window.setTimeout(callback, 17 /*~ 1000/60*/);
                                  });
};

/*取消动画*/
if (!window.cancelRequestAnimationFrame) {
  window.cancelRequestAnimationFrame = (window.cancelAnimationFrame ||
                                        window.webkitCancelRequestAnimationFrame ||
                                        window.mozCancelRequestAnimationFrame ||
                                        window.msCancelRequestAnimationFrame ||
                                        window.oCancelRequestAnimationFrame ||
                                        window.clearTimeout);
};



/*事件绑定*/
var kekeDom = function(id){
	var dom = document.getElementById(id);
	return {
		on:function(type,callback){
			if(document.addEventListener){
				dom.addEventListener(type,callback,false);
			}else if(document.attachEvent){
				dom.attachEvent("on"+type,callback);
			}else{
				dom["on"+type]=callback;
			}
		},

		mouse:function(){
			var cmouse = {x: 0, y: 0, event: null},
			  body_scrollLeft = document.body.scrollLeft,
			  element_scrollLeft = document.documentElement.scrollLeft,
			  body_scrollTop = document.body.scrollTop,
			  element_scrollTop = document.documentElement.scrollTop,
			  offsetLeft = dom.offsetLeft,
			  offsetTop = dom.offsetTop;
			  dom.addEventListener('mousemove', function (event) {
				var x, y;
				if (event.pageX || event.pageY) {
				  x = event.pageX;
				  y = event.pageY;
				} else {
				  x = event.clientX + body_scrollLeft + element_scrollLeft;
				  y = event.clientY + body_scrollTop + element_scrollTop;
				}
				x -= offsetLeft;
				y -= offsetTop;
				cmouse.x = x;
				cmouse.y = y;
				cmouse.event = event;
			}, false);
			return cmouse;
		},

		keyboard:function(callback){
			window.addEventListener("keydown",function(event){
				switch(event.keyCode){
					case 38 : callback.call(event,1);break;
					case 39 : callback.call(event,2);break;
					case 40 : callback.call(event,3);break;
					case 37 : callback.call(event,4);break;
					default:callback.call(event,5);break;
				}
			},false);
			window.addEventListener("keyup",function(event){
				switch(event.keyCode){
					case 38 : callback.call(event,1);break;
					case 39 : callback.call(event,2);break;
					case 40 : callback.call(event,3);break;
					case 37 : callback.call(event,4);break;
					default:callback.call(event,5);break;
				}
			},false);
		},

		parseColor : function (color, flag) {//用法:parseColor("#111111",true) ==1118481  alert(kekeDom().parseColor(1118481,false)) ==#111111
		  if (flag === true) {
			if (typeof color === 'number') {
			  return (color | 0); //chop off decimal
			}
			if (typeof color === 'string' && color[0] === '#') {
			  color = color.slice(1);
			}
			return window.parseInt(color, 16);
		  } else {
			if (typeof color === 'number') {
			  color = '#' + ('00000' + (color | 0).toString(16)).substr(-6); //pad
			}
			return color;
		  }
		},

		colorToRGB : function (color, alpha) {//用法:colorToRGB("#111111",0.5)==rgba(0,1,17,0.5)
		  //number in octal format or string prefixed with #
		  if (typeof color === 'string' && color[0] === '#') {
			color = window.parseInt(color.slice(1), 16);
		  }
		  alpha = (alpha === undefined) ? 1 : alpha;
		  //parse hex values
		  var r = color >> 16 & 0xff,
			  g = color >> 8 & 0xff,
			  b = color & 0xff,
			  a = (alpha < 0) ? 0 : ((alpha > 1) ? 1 : alpha);
		  //only use 'rgba' if needed
		  if (a === 1) {
			return "rgb("+ r +","+ g +","+ b +")";
		  } else {
			return "rgba("+ r +","+ g +","+ b +","+ a +")";
		  }
		},

		randomColor:function(){
			var r = Math.floor(Math.random()*256);
			var g = Math.floor(Math.random()*256);
			var b = Math.floor(Math.random()*256);
			return "rgb("+r+","+g+","+b+")";//IE7不支出rgb
		},

		randomColor16:function(){
			//0-255	
			var r = random(255).toString(16);
			var g = random(255).toString(16);
			var b = random(255).toString(16);
			//255的数字转换成十六进制
			if(r.length<2)r = "0"+r;
			if(g.length<2)g = "0"+g;
			if(b.length<2)b = "0"+b;
			return "#"+r+g+b;
		},

		random:function(){
			return Math.floor(Math.random()*(num+1));
		},

		randomRange:function(start,end){
			return Math.floor(Math.random()*(end-start+1))+start;
		}
	};
};