function generateModule() {
    
    function createResult(result, notice) {        
        return {
            notice: notice,
            result: result,
            info: function() {
                return '>> ' + this.notice + ', ' + this.result;
            }
        }        
    }
    
    var module = {
    
        add: function(a, b) {
            print('module -- add ', a, ' + ', b);
            return createResult(a + b, 'summation');
        },
        
        sub: function(a, b) {
            print('module -- sub ', a, ' - ', b);
            return createResult(a - b, 'subtraction')
        },
        
        handleResult: function(result) {
            print('handle result -- ', result);
            print('calling info of result: ', result.info());
        }
    
    }
    
    return module;    
}

var mod = generateModule();

function add(a, b) {
    return mod.add(a, b);
}

function sub(a, b) {
    return mod.sub(a, b);
}

function handle(result) {
    mod.handleResult(result);
}