/**
*	Site-specific configuration settings for Highslide JS
*/
hs.graphicsDir = '/myWeibo/highslide/graphics/';
hs.outlineType = 'custom';
hs.dimmingOpacity = 0.75;
hs.fadeInOut = true;
hs.align = 'center';
hs.useBox = true;
hs.width = 600;
hs.height = 400;
hs.captionEval = 'this.a.title';
hs.showCredits = false;


// Add the slideshow controller
hs.addSlideshow({
	slideshowGroup: 'group1',
	interval: 5000,
	repeat: false,
	useControls: true,
	fixedControls: 'fit',
	overlayOptions: {
		opacity: 1,
		position: 'bottom center',
		offsetX: 0,
		offsetY: -15,
		hideOnMouseOut: true
	}
});

// Chinese simplified language strings
hs.lang = {
	cssDirection: 'ltr',
	loadingText: '载入中...',
	loadingTitle: '取消',
	focusTitle: '置于最前',
	fullExpandTitle: '原始尺寸',
	creditsText: '基于<i>Highslide JS</i>',
	creditsTitle: '查看 Highslide JS 官方首页',
	previousText: '上一张',
	nextText: '下一张',
	moveText: '移动',
	closeText: '关闭',
	closeTitle: '关闭 (退出键)',
	resizeTitle: '调整尺寸',
	playText: '播放',
	playTitle: '播放幻灯片 (空格键)',
	pauseText: '暂停',
	pauseTitle: '暂停幻灯片 (空格键)',
	previousTitle: '上一张 (左方向键)',
	nextTitle: '下一张 (右方向键)',
	moveTitle: '移动',
	fullExpandText: '完整尺寸',
	number: 'Image %1 of %2',
	restoreTitle: '单击关闭图片,单击不放拖动图片。使用方向键进行图片切换。'
};

// gallery config object
var config1 = {
	slideshowGroup: 'group1',
	transitions: ['expand', 'crossfade']
};
