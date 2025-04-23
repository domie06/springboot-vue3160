const base = {
    get() {
        return {
            url : "http://localhost:8080/huibiankechengwangzhan/",
            name: "huibiankechengwangzhan",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/huibiankechengwangzhan/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "汇编课程网站"
        } 
    }
}
export default base
