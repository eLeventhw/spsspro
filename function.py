import math
import os
import sys
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from collections import Counter
'''
    传入数据格式均为pd.Dataframe
    图片位于 'D:\res_photo' res_photo为文件夹 需要自己建
    生成的图片有固定名字，见代码
    有的算法有图有的没图
    传入数据维数有标注
    调用格式:
    String[] args1 = new String[]{"python","D:\\pythonProject\\function.py",algorthm(算法),参数1,"#",参数2,"#",.....,"#"}
    即每个参数后加'#'
    Runtime.getRuntime().exec(arg1)
    获取变量数可以首先调用getdata.py
'''
plt.rc('font',family='SimHei')#用来正常显示中文标签
# plt.rc('font',size=16)#设置显示字体大小
plt.rc('axes',unicode_minus=False)#正常显示负号
def find(x,start):
    for i in range(start,len(x)):
        if(x[i]=="#"):
            return i
def file_exist(path):
    if (os.path.exists(path)):
        os.remove(path)
def get_data(path):
    if(path[-3:]=='csv'):
        df=pd.read_csv(path)
    elif(path[-4:]=='xlsx'):
        df=pd.read_excel(path)
    return df
#评价类 多维 测试完成
def CRITIC(data,negative,positive):#先选negative再选positive
    import copy
    name=data.columns
    the = np.std(data, axis=0, ddof=1)
    if (negative != []):
        for variable in negative:
            data[variable] = (data[variable].max() - data[variable]) / (data[variable].max() - data[variable].min())
    if (positive != []):
        for variable in positive:
            data[variable] = (data[variable] - data[variable].min()) / (data[variable].max() - data[variable].min())
    data=data.values
    # the = np.std(data, axis=0, ddof=1)
    data2=copy.deepcopy(data)
    data2=list(map(list,zip(*data2)))
    r=np.corrcoef(data2)
    f=np.sum(1-r,axis=1)
    c=np.array(the*f)#信息承载量
    w=c/sum(c) #权重
    f=pd.DataFrame(f,index=name,columns=['指标冲突性'])
    c=pd.DataFrame(c,index=name,columns=['信息承载量'])
    w=pd.DataFrame(w,index=name,columns=['权重'])
    print('CRITIC法是一种比熵权法和标准离差法更好的客观赋权法。基于评价指标的对比强度和指标之间的冲突性来综合衡量指标的客观权重。')
    print('详细结果:')
    print(f)
    print(c)
    print(w)
    import seaborn as sns
    plt.figure(figsize=(10,6))
    g=sns.barplot(name,w)
    for p in g.patches:
        g.annotate('{:.3f}'.format(p.get_height()), (p.get_x() + 0.4, p.get_height()),
                       ha='center', va='bottom',
                       color='black')
    plt.xlabel('变量')
    plt.ylabel("权重")
    f = plt.gcf()
    file_exist(r'D:\res_photo\CRITIC_权重.png')
    f.savefig(r'D:\res_photo\CRITIC_权重.png')
    f.clear()
def entropy_weight(data,negative,positive):#先选negative再选positive
    try:
        name=data.columns
        if(negative!=[]):
            for variable in negative:
                data[variable]=(data[variable].max()-data[variable])/(data[variable].max()-data[variable].min())
        if(positive!=[]):
            for variable in positive:
                data[variable] = (data[variable] - data[variable].min())/(data[variable].max()-data[variable].min())
        #非负平移
        data = data + 0.001
        p=data/data.sum(axis=0)
        #计算熵值
        E=np.nansum(-p*np.log(p)/np.log(len(data)),axis=0)
        #权重矩阵
        W=(1-E)/(1-E).sum()
        w=W
        e=E
        f= pd.DataFrame(E, index=name, columns=['熵值'])
        W = pd.DataFrame(W, index=name, columns=['权重'])
        print('熵权法是一种客观赋权方法，在具体使用过程中，根据各指标的数据的分散程度，利用信息熵计算出各指标的熵权，再根据各指标对熵权进行一定的修正，从而得到较为客观的指标权重。')
        print('详细结果:')
        print(f)
        print(W)
        import seaborn as sns
        plt.figure(figsize=(10,6))
        g=sns.barplot(name,w)
        for p in g.patches:
            g.annotate('{:.3f}'.format(p.get_height()), (p.get_x() + 0.4, p.get_height()),
                           ha='center', va='bottom',
                           color='black')
        plt.xlabel('变量')
        plt.ylabel("权重")
        f = plt.gcf()
        file_exist(r'D:\res_photo\熵权法权重.png')
        f.savefig(r'D:\res_photo\熵权法权重.png')
        f.clear()
        return [e,w]
    except Exception as e:
        print(e)
def TOPSIS(data,negative,positive):#先选negative再选positive
    #指标正向化
    try:
        name=data.columns
        W=entropy_weight(data,negative,positive)[1]
        #正向化
        for variable in negative:
            data[variable] = data[variable].max() - data[variable]
        #标准化
        for variable in data.columns:
            data[variable]=data[variable]/sum(data[variable]**2)**0.5
        data=data.values
        z0=data.min(axis=0)
        z1=data.max(axis=0)
        temp=data.copy()
        d1=[0 for i in range(len(data))]
        d0=d1.copy()
        for i in range(len(d1)):
            # d1[i]=(((z1-data1[i])**2).sum())**0.5
            d1[i] = ((W * (z1 - data[i]) ** 2).sum()) ** 0.5
        for i in range(len(d1)):
            # d0[i] = (((z0 - data1[i]) ** 2).sum()) ** 0.5
            d0[i]=((W*(z0-data[i])**2).sum())**0.5
        d0=np.array(d0)
        d1=np.array(d1)
        s=d0/(d1+d0)
        ind1=np.argsort(-s)
        ind11=np.zeros(len(ind1))
        ind11[ind1]=np.arange(1,len(ind1)+1)
        W= pd.DataFrame(W, index=name, columns=['权重'])
        s = pd.DataFrame(s, columns=['得分'])
        ind11 = pd.DataFrame(ind11,columns=['排名'])
        res=pd.concat([ind11,s],axis=1)
        print('TOPSIS法根据有限个评价对象与理想化目标的接近程度进行排序的方法，是在现有的对象中进行相对优劣的评价。')
        print('默认使用熵权法确定权重')
        print('详细结果:')
        print(res)
    except Exception as e:
        print(e)
    #权重，得分,排名
def kmo(data):
    data_corr=data.corr()
    corr_inv = np.linalg.inv(data_corr)
    nrow_inv_corr, ncol_inv_corr = data_corr.shape
    A = np.ones((nrow_inv_corr, ncol_inv_corr))
    for i in range(0, nrow_inv_corr, 1):
        for j in range(i, ncol_inv_corr, 1):
            A[i, j] = -(corr_inv[i, j]) / (math.sqrt(corr_inv[i, i] * corr_inv[j, j]))
            A[j, i] = A[i, j]
    dataset_corr = np.asarray(data_corr)
    kmo_num = np.sum(np.square(dataset_corr)) - np.sum(np.square(np.diagonal(A)))
    kmo_denom = kmo_num + np.sum(np.square(A)) - np.sum(np.square(np.diagonal(A)))
    kmo_value = kmo_num / kmo_denom
    return kmo_value#大于0.6则说明有相关性 大于0.8则非常适合主成分分析 小于0.5则不合适
def bartlett_test(data):
    from factor_analyzer.factor_analyzer import calculate_bartlett_sphericity
    square_value,p_value=calculate_bartlett_sphericity(data)
    return p_value#p<0.05则可进行主成分分析
def PCA_func(data):#data多维(>=2维)
    from sklearn.decomposition import PCA
    from scipy.stats import zscore
    kmo_value=kmo(data)
    p_value=bartlett_test(data)
    data=data.values
    c=zscore(data,ddof=1)
    md=PCA().fit(c)
    r=md.explained_variance_ratio_
    xs=md.components_
    d=np.cumsum(r)
    #碎石图
    plt.figure(figsize=(10, 6))
    plt.rc('font',size=14)
    plt.plot(range(1,len(md.explained_variance_)+1),md.explained_variance_)
    for a,b in zip(range(1,len(d)+1),md.explained_variance_):
        plt.text(a-0.15,b+0.03,'%.3f'%b)
    if(len(d)<9):
        plt.xticks(range(1,len(md.explained_variance_)+1))
    plt.xlabel('因子个数')
    plt.ylabel('特征值')
    f = plt.gcf()
    file_exist(r'D:\res_photo\PCA_碎石图.png')
    f.savefig(r'D:\res_photo\PCA_碎石图.png')
    f.clear()
    n=0
    for i in range(len(d)):
        if(d[i]>0.9):
            n=i+1
            break
    score=c@(xs[:n,:].T)
    g=score@r[:n]#综合评价得分
    ind1=np.argsort(-g)
    ind11=np.zeros(len(ind1))
    ind11[ind1]=np.arange(1,len(ind1)+1)
    score=pd.DataFrame(g,columns=['得分'])
    ind11=pd.DataFrame(ind11,columns=['排名'])
    res=pd.concat([score,ind11],axis=1)
    print('主成分分析旨在利用降维的思想，把多指标转化为少数几个综合指标。')
    print('首先进行KMO和Bartlett的检验,对于KMO值：0.8上非常合适做主成分分析，0.7-0.8之间一般适合，0.6-0.7之间不太适合，0.5-0.6之间表示差，0.5下表示极不适合;'
          '对于 Bartlett的检验，若P小于0.05,则说明可以做主成分分析。')
    print('KMO检验和Bartlett检验：kmo_value=',kmo_value,'Bartlett_pvalue=',p_value)
    print('详细结果:')
    print(res)
    return [kmo_value,p_value,g,ind11]#kmo值，p值，得分和排名
#预测 一维
def MoveAverage(y,N=1):#y一维
    l=[]
    for i in range(N+1,len(y)+2):
        M=y[i-N-1:i-1].mean()
        l.append(round(M))
    Mt=np.array(l)
    s = np.sqrt(((y[N:] - Mt[:-1]) ** 2).mean())
    print('移动平均法移动平均法是一种简单平滑预测技术,适用于即期预测。')
    print('详细结果：')
    s=float(s)
    print('预测的残差方差:',s)
    print('移动平均序列：')
    for i in range(len(Mt)):
        if(i!=len(Mt)-1):
            print(Mt[i][0],',',end='')
        else:
            print(Mt[i][0],end='')
    return [s,Mt]#残差方差和移动平均序列
def expmove(y,a=0.8):#指数平滑法 y一维
    y=np.array(y)
    n=len(y)
    l=[]
    l.append(y[0])
    print('s')
    for i in range(1,n):
        l.append(a*y[i-1]+(1-a)*l[i-1])
    l=np.array(l)
    s = np.sqrt(((y - l) ** 2).mean())
    Mt=np.array(l)
    print('指数平滑法是生产预测中常用的一种方法，也用于中短期经济发展趋势预测。')
    print('详细结果:')
    print('残差方差:',float(s))
    print('下一次的预测值:',a*y[-1]+(1-a)*Mt[-1])
    print('指数平滑序列:')
    for i in range(len(Mt)):
        if(i!=len(Mt)-1):
            print(Mt[i][0],',',end='')
        else:
            print(Mt[i][0],end='')
    return [s,Mt,a*y[-1]+(1-a)*Mt[-1]]#残差方差，指数平滑序列，下一次的预测值
#有问题
def gray_model_GM11(data,name,N=3):#一维  数据与向后预测的期数
    import sympy as sp
    data=np.array(data)
    n = len(data)
    def level_check():#级比检验
        lamda=data[:-1]/data[1:]
        b1=[min(lamda),max(lamda)]
        b2=[np.exp(-2/(n+1)),np.exp(2/(n+1))]#级比允许范围
        return b1[0]>=b2[0] and b1[1]<=b2[1]
    flag=level_check()
    add_num=max(abs(data))
    i=0
    while(not flag):#平移变换
        data=data+add_num
        flag=level_check()
        i+=1
    lamda=data[:-1]/data[1:]
    x1 = np.cumsum(data)  # 求累加序列
    z=(x1[:-1]+x1[1:])/2#求均值生成序列
    B=np.vstack([-z,np.ones(n-1)]).T
    try:
        u=np.linalg.pinv(B)@data[1:]#最小二乘法拟合参数
        t=sp.var('t')#定义符号变量
        x=sp.var('x',cls=sp.Function)#定义符号函数
        eq=x(t).diff(t)+u[0]*x(t)-u[1]#定义符号微分方程
        xt0=sp.dsolve(eq,ics={x(0):data[0]})#求解符号微分方程
        print(type(xt0))
        xt0=xt0.args[1]#提取方程符号解  断点  xt0.args有误
        xt=sp.lambdify(t,xt0,'numpy')#转化为匿名函数
        t=np.arange(n+N)
        xh=xt(t)#求预测值
        x0h=np.hstack([data[0],np.diff(xh)])#还原数据b
        x0h=x0h-i*add_num#预测值
        data = data - i * add_num
        x=x0h[-N:]#提取预测数据
        cha=data-x0h[:n]#残差
        delta=abs(cha/data)*100#相对误差%
        err=delta.mean()
        rho=abs(1-(1-0.5*u[0])/(1+0.5*u[0])*lamda)#级比偏差
        plt.rc('font', size=14)
        plt.plot(range(n),data, '--o', label='原始数据')
        plt.plot(range(n),x0h[:n] , '-*', label='预测数据')
        plt.xlabel('periods')
        plt.ylabel('{}'.format(name))
        plt.legend()
        f = plt.gcf()
        file_exist(r'D:\res_photo\GM11_model.png')
        f.savefig(r'D:\res_photo\GM11_model.png')
        f.clear()
        return [err,x]#平均相对误差与预测值
    except Exception as e:
        print(e)
#回归类
def po(x,y):
    import statsmodels.api as sm
    y_n = '{}'.format(y.columns[0])
    x_n = '{}'.format(x.columns[0])
    x = np.array(x)
    y = np.array(y)
    d = {'y': y, 'x': x}
    s1='y~x'
    s2='y~x+I(x**2)'
    s3='y~x+I(x**2)+I(x**3)'
    md1=sm.formula.ols(s1,d).fit()
    md2=sm.formula.ols(s2,d).fit()
    md3=sm.formula.ols(s3,d).fit()
    def func(md,n,data):
        y=0
        for i in range(n+1):
            y+=md.params[i]*(data**i)
        return y
    x0 = np.linspace(x.min(), x.max(), 100)
    y1=func(md1,1,x0)
    y2=func(md2,2,x0)
    y3=func(md3,3,x0)
    plt.scatter(x,y)
    plt.plot(x0,y1,label='线性回归')
    plt.plot(x0,y2,label='二次回归')
    plt.plot(x0,y3,label='三次回归')
    plt.xlabel('{}'.format(x_n))
    plt.ylabel('{}'.format(y_n))
    plt.legend()
    f = plt.gcf()
    file_exist(r'D:\res_photo\compare.png')
    f.savefig(r'D:\res_photo\compare.png')
    f.clear()
    para1=np.array(md1.params)
    para2=np.array(md2.params)
    para3=np.array(md3.params)
    s1 = '{}'.format(y_n)
    s1 = s1 + '='+'%.2f'%para1[0] + '+'+'%.2f'%para1[1] + '*{}'.format(x_n)
    s2='{}'.format(y_n)+'='
    for i in range(len(para2)):
        if(i!=0):
            m='%.2f'%para2[i]+'*{}'.format(x_n)+'^{}'.format(i)
            if(i!=len(para2)-1):
                m=m+'+'
        else:
            m='%.2f'%para2[0]+'+'
        s2=s2+m
    s3 = '{}'.format(y_n) + '='
    for i in range(len(para3)):
        if(i!=0):
            m='%.2f'%para3[i]+'*{}'.format(x_n)+'^{}'.format(i)
            if(i!=len(para3)-1):
                m=m+'+'
        else:
            m='%.2f'%para3[0]+'+'
        s3=s3+m
    print('详细结果:')
    print(s1,end=',')
    print('R-Square:%.2f'%md1.rsquared,end=',')
    print('R-Squared_adj:%.2f'%md1.rsquared_adj)
    print(s2, end=',')
    print('R-Square:%.2f'%md2.rsquared, end=',')
    print('R-Squared_adj:%.2f'%md2.rsquared_adj)
    print(s3, end=',')
    print('R-Square:%.2f'%md3.rsquared, end=',')
    print('R-Squared_adj:%.2f'%md3.rsquared_adj)
def linear_regression(x,y):#x一维，y一维
    import statsmodels.api as sm
    y_n='{}'.format(y.columns[0])
    x_n='{}'.format(x.columns[0])
    x=np.array(x)
    y=np.array(y)
    d={'y':y,'x':x}
    md=sm.formula.ols('y~x',d).fit()
    plt.figure(figsize=(10,6))
    def func(data):
        return md.params[1]*data+md.params[0]
    x0=np.linspace(x.min(),x.max(),100)
    y0=func(x0)
    plt.scatter(x,y)
    plt.plot(x0,y0)
    f = plt.gcf()
    file_exist(r'D:\res_photo\linear_regression.png')
    f.savefig(r'D:\res_photo\linear_regression.png')
    f.clear()
    para=np.array(md.params)
    s='{}'.format(y_n)
    s=s+'='
    for i in range(len(para)):
        if(i!=0):
            m='{}'.format(para[i])+'*{}'.format(x_n)+'^{}'.format(i)
            if(i!=len(para)-1):
                m=m+'+'
        else:
            m='{}'.format(para[0])+'+'
        s=s+m
    print('详细结果:')
    print(s)
    print('R-Square:',md.rsquared)
    print('R-Squared_adj:',md.rsquared_adj)
    return [para,md.rsquared,md.rsquared_adj]#系数与R方,调整R方
def poly_regression(x,y,n=2):#数据和次数 x一维，y一维
    import statsmodels.formula.api as smf
    y_n='{}'.format(y.columns[0])
    x_n='{}'.format(x.columns[0])
    x=np.array(x)
    y=np.array(y)
    s='y~x'
    for i in range(2,n+1):
        s+='+I(x**{})'.format(i)
    d={'y':y,'x':x}
    md=smf.ols(s,d).fit()
    def func(data):
        y=0
        for i in range(n+1):
            y+=md.params[i]*(data**i)
        return y
    x0 = np.linspace(x.min(), x.max(), 100)
    y0 = func(x0)
    plt.figure(figsize=(10, 6))
    plt.scatter(x, y)
    plt.plot(x0, y0)
    f = plt.gcf()
    file_exist(r'D:\res_photo\poly_regression.png')
    f.savefig(r'D:\res_photo\poly_regression.png')
    f.clear()
    print('详细结果:')
    para = np.array(md.params)
    s = '{}'.format(y_n)
    s = s + '='
    for i in range(len(para)):
        if (i != 0):
            m = '{}'.format(para[i]) + '*{}'.format(x_n) + '^{}'.format(i)
            if (i != len(para) - 1):
                m = m + '+'
        else:
            m = '{}'.format(para[0]) + '+'
        s = s + m
    print(s)
    print('R-Square:', md.rsquared)
    print('R-Squared_adj:', md.rsquared_adj)
    return [np.array(md.params), md.rsquared, md.rsquared_adj]
#
def exp_regression(x,y):#x一维
    from scipy import optimize
    y_n = '{}'.format(y.columns[0])
    x_n = '{}'.format(x.columns[0])
    x=np.array(x)
    y=np.array(y)
    def func(x, a, b):
        x = np.array(x)
        return a*np.exp(b*x)
    try:
        popt, pcov = optimize.curve_fit(func, x, y,maxfev=5000)#断点
        m = np.mean(y)
        ss_tot = np.sum((y - m) ** 2)
        ss_res = np.sum((y - func(x, *popt)) ** 2)
        r_squared = 1 - (ss_res / ss_tot)
        x0 = np.linspace(x.min(), x.max(), 100)
        y0 = func(x0,popt[0],popt[1])
        plt.scatter(x, y)
        plt.plot(x0, y0)
        f = plt.gcf()
        file_exist(r'D:\res_photo\exp_regression.png')
        plt.savefig(r'D:\res_photo\exp_regression.png')
        f.clear()
        print('详细结果:')
        s='{}'.format(y_n)+'='+'{}'.format(popt[0])+'*'+'e^{}'.format(popt[1])+'*{}'.format(x_n)
        print(s)
        return [popt[0],popt[1],r_squared]#[a,b,R]#有问题
    except:
        popt=[0,0]
        print('达到最大迭代次数,数据不合适')
        return [0,0,0]
def ridge_regression(x,y):#x可多维,y一维 x，y必须输入
    from sklearn.linear_model import Ridge
    y_n = '{}'.format(y.columns[0])
    x_n=np.array(x.columns)
    x=np.array(x)
    y=np.array(y)
    ridge_reg = Ridge(alpha=0.4, solver='sag')#alpha为正则项系数，'sag'为随机梯度下降
    ridge_reg.fit(x, y)
    s=y_n+'='+'{}'.format(ridge_reg.intercept_[0])
    print('岭回归是一种改良的最小二乘估计法，通过放弃最小二乘法的无偏性，以损失部分信息、降低精度为代价获得回归系数，它是更为符合实际、更可靠的回归方法，对存在离群点的数据的拟合要强于最小二乘法。')
    print('详细结果:')
    for i in range(len(x_n)):
        s=s+'+'+'{}'.format(ridge_reg.coef_[0][i])+'*'+'{}'.format(x_n[i])
    print(s)
    print('R-Square:',ridge_reg.score(x,y))
    return [ridge_reg.intercept_,ridge_reg.coef_,ridge_reg.score(x,y)]#截距，系数，R方
def LSRegression(x,y):#x,y可多维 x，y必须输入
    from sklearn.cross_decomposition import PLSRegression
    from sklearn.model_selection import cross_val_predict
    from sklearn.metrics import mean_squared_error
    from scipy.stats import zscore
    y_n=np.array(y.columns)
    x_n = np.array(x.columns)
    x=np.array(x)
    y=np.array(y)
    x_l=len(x[0])
    df=np.hstack((x,y))
    mu = df.mean(axis=0)
    standard = df.std(axis=0, ddof=1)
    r = np.corrcoef(df.T)
    d = zscore(df, ddof=1)  # 数据标准化
    a = d[:, :x_l]  # x
    b = d[:, x_l:]  # y
    n = a.shape[1]
    m = b.shape[1]  # 自变量和因变量的个数
    mse = []  # 均方差
    for i in range(1, n + 1):
        pls = PLSRegression(i)
        y_cv = cross_val_predict(pls, a, b)
        mse.append(mean_squared_error(b, y_cv))
    nmin = np.argmin(mse)
    # print("建议成分个数：", nmin + 1)
    md = PLSRegression(nmin + 1).fit(a, b)
    b = md.coef_  # 每一列是y对x的回归系数
    # print("标准化数据的回归系数:\n", b)
    b0 = np.zeros((n + 1, m))
    b0[0, :] = mu[n:] - mu[:n] / standard[:n] @ b * standard[n:]
    for i in range(m):
        b0[1:, i] = standard[n + i] / standard[:n] * b[:, i]
    # print("原始数据回归系数：\n", b0)
    print('偏最小二乘回归是一种将主成分分析、典型性相关分析和回归分析结合的方法，一般用于处理样本量过少且存在相关性的回归问题')
    print('详细结果:')
    print('建议成分个数:',nmin+1)
    for i in range(len(y_n)):
        s='{}='.format(y_n[i])
        for j in range(len(b0)):
            if(j!=0):
                s=s+'+{}'.format(b0[j][i])+'*{}'.format(x_n[j-1])
            else:
                s=s+'{}'.format(b0[i][0])
        print(s)
    print('均方差:',mse[nmin])
    return [mse[nmin],b0]#均方差与回归系数
#机器学习分类  x均可多维
def decision_tree(x,y,x_pre=pd.DataFrame([])):#x可多维，y一维 数据量需较大
    try:
        classname = y[y.columns[0]].unique()
        l = np.zeros(y.shape[0])
        y = y[y.columns[0]]
        for i in range(len(classname)):
            for j in range(y.shape[0]):
                if(y[j]==classname[i]):
                    l[j]=i
        x=x.astype(int)
        y=l
        from sklearn import tree
        from sklearn.model_selection import train_test_split
        from sklearn.model_selection import GridSearchCV
        from sklearn.tree import DecisionTreeClassifier
        tree_params = {'max_depth': range(1,11)}
        X_train, X_test, Y_train, Y_test = train_test_split(x, y, test_size=0.3)#默认30%为测试数据
        locally_best_tree = GridSearchCV(DecisionTreeClassifier(),tree_params)
        locally_best_tree.fit(X_train, Y_train)
        clf = tree.DecisionTreeClassifier(criterion="entropy",max_depth=locally_best_tree.best_params_['max_depth'])
        clf = clf.fit(X_train, Y_train)
        score = clf.score(X_test, Y_test)
        if(x_pre.empty):
            y_pre=[]
        else:
            y_pre=clf.predict(x_pre)
        #绘图
        import graphviz
        dot_data = tree.export_graphviz(clf, out_file=None
                                        , filled=True, rounded=True,feature_names=x.columns)#断点
        graph1 = graphviz.Source(dot_data.replace('helvetica', 'Microsoft YaHei UI'), encoding='utf-8')
        print('决策树分类是利用树结构进行分类的一种模型。')
        if(len(y_pre)!=0):
            print('预测结果:')
            for i in range(len(y_pre)):
                print(y_pre[i],',',end='')
        print('模型准确率:')
        print(score)
        file_exist(r'D:\res_photo\decision_tree_res')
        graph1.render(r"D:\res_photo\decision_tree_res")
        return [score,y_pre]
    except Exception as e:
        print(e)
def random_forest(x,y,x_pre=pd.DataFrame([])):#x可多维，y一维 数据量需较大
    from sklearn.ensemble import RandomForestClassifier
    from sklearn.model_selection import train_test_split
    classname = y[y.columns[0]].unique()
    l = np.zeros(y.shape[0])
    y=y[y.columns[0]]
    for i in range(len(classname)):
        for j in range(y.shape[0]):
            if (y[j] == classname[i]):
                l[j] = i
    x = x.astype(int)
    y = l
    X_train, X_test, Y_train, Y_test = train_test_split(x, y, test_size=0.3)
    clf = RandomForestClassifier()
    clf.fit(X_train, Y_train)
    if (x_pre.empty):
        y_pre = []
    else:
        y_pre = clf.predict(x_pre)
    score = clf.score(X_test, Y_test)
    print('随机森林分类是多棵决策树组合在一起的多数投票结果。')
    if (len(y_pre) != 0):
        print('预测结果:')
        for i in range(len(y_pre)):
            print(y_pre[i], ',', end='')
    print('模型准确率:')
    print(score)
    return [score,y_pre]
def Adaboost(x,y,x_pre=pd.DataFrame([])):#x可多维，y一维 数据量需较大
    from sklearn.ensemble import AdaBoostClassifier
    from sklearn.model_selection import train_test_split
    classname = y[y.columns[0]].unique()
    l = np.zeros(y.shape[0])
    y=y[y.columns[0]]
    for i in range(len(classname)):
        for j in range(y.shape[0]):
            if (y[j] == classname[i]):
                l[j] = i
    x = x.astype(int)
    y = l
    X_train, X_test, Y_train, Y_test = train_test_split(x, y, test_size=0.3)
    clf = AdaBoostClassifier()
    clf.fit(X_train, Y_train)
    if (x_pre.empty):
        y_pre = []
    else:
        y_pre = clf.predict(x_pre)
    score = clf.score(X_test, Y_test)
    print('adaboost是利用前一次迭代弱学习器的错误率来更新训练集的权重。')
    if (len(y_pre) != 0):
        print('预测结果:')
        for i in range(len(y_pre)):
            print(y_pre[i], ',', end='')
    print('模型准确率:')
    print(score)
    return [score,y_pre]
def KNN_classify(x,y,x_pre=pd.DataFrame([])):#x可多维，y一维 数据量需较大
    from sklearn.neighbors import KNeighborsClassifier
    from sklearn.model_selection import train_test_split
    classname = y[y.columns[0]].unique()
    l = np.zeros(y.shape[0])
    y=y[y.columns[0]]
    for i in range(len(classname)):
        for j in range(y.shape[0]):
            if (y[j] == classname[i]):
                l[j] = i
    x = x.astype(int)
    y = l
    X_train, X_test, Y_train, Y_test = train_test_split(x, y, test_size=0.3)
    clf = KNeighborsClassifier()
    clf.fit(X_train, Y_train)
    if (x_pre.empty):
        y_pre = []
    else:
        y_pre = clf.predict(x_pre)
    score = clf.score(X_test, Y_test)
    print('K近邻(KNN)分类，是使用最邻近的K个实例，来判断新样本类别的一种有监督算法。')
    if (len(y_pre) != 0):
        print('预测结果:')
        for i in range(len(y_pre)):
            print(y_pre[i], ',', end='')
    print('模型准确率:')
    print(score)
    return [score,y_pre]
def Logistic_classify(x,y,x_pre=pd.DataFrame([])):#x可多维，y一维 数据量需较大
    from sklearn.linear_model import LogisticRegression
    from sklearn.model_selection import train_test_split
    classname = y[y.columns[0]].unique()
    l = np.zeros(y.shape[0])
    y=y[y.columns[0]]
    for i in range(len(classname)):
        for j in range(y.shape[0]):
            if (y[j] == classname[i]):
                l[j] = i
    x = x.astype(int)
    y = l
    X_train, X_test, Y_train, Y_test = train_test_split(x, y, test_size=0.3)
    clf = LogisticRegression()
    clf.fit(X_train, Y_train)
    if (x_pre.empty):
        y_pre = []
    else:
        y_pre = clf.predict(x_pre)
    score = clf.score(X_test, Y_test)
    print('逻辑回归是一个分类算法，它可以处理二元分类以及多元分类。')
    if (len(y_pre) != 0):
        print('预测结果:')
        for i in range(len(y_pre)):
            print(y_pre[i], ',', end='')
    print('模型准确率:')
    print(score)
    return [score,y_pre]
def machine(x,y,xpre=pd.DataFrame([])):
    st=decision_tree(x,y)[0]
    srf=random_forest(x,y)[0]
    sa=Adaboost(x,y)[0]
    sKnn=KNN_classify(x,y)[0]
    sl=Logistic_classify(x,y)[0]
    score=[st,srf,sa,sKnn,sl]
    x=['决策树','随机森林','Adaboost','KNN','Logistic']
    import seaborn as sns
    sns.set()
    plt.rc('font', family='SimHei')  # 用来正常显示中文标签
    sns.barplot(x,score)
    f = plt.gcf()
    file_exist(r'D:\res_photo\machine.png')
    f.savefig(r'D:\res_photo\machine.png')
    f.clear()
#适用二分类 可先不做
def logic(x,y):#p=1/(1-e^-(a+bx1+cx2+...)  x可多维
    import statsmodels.api as sm
    x=np.array(x)
    d = {'y': y}
    for i in range(len(x[0])):
        d['x{}'.format(i+1)]=x[:,i]
    s='y~'
    for i in range(len(x[0])):
        s+='x{}'.format(i+1)
        s+='+'
    s=s[:-1]
    md=sm.formula.logit(s,d)
    md=md.fit(method='bfgs',maxiter=50)
    def check():
        a=np.array(md.params)[1:]@x.T+np.array(md.params)[0]
        p=1/(1-np.exp(-a))
        res=p<0.5
        print(res)
        res=res.astype(int)
        ans=sum((res==y))/len(y)
        return max(ans,1-ans)
    return [check(),np.array(md.params)]#准确率与系数#适用二分类
#时间序列预测
def ADF(data):#一维
    from statsmodels.tsa.stattools import adfuller
    res=adfuller(data)
    result_fromat = pd.Series(res[0:4], index=['Test Statistic','p-value','Lags Used','Number of Observations Used'])
    # print(result_fromat)#p-value>=0.05则为不平稳序列
    print('ADF是用于判断时间序列是否平稳的一种方法')
    print('通过分析t值，分析其是否可以显著地拒绝序列不平稳的原假设(P<0.05)。')
    print('若呈显著性，表明拒绝序列不平稳的原假设，该序列为一个平稳的时间序列。')
    print('详细结果:')
    print('t值:',result_fromat['Test Statistic'])
    print('p值:',result_fromat['p-value'])
    if result_fromat['p-value']>=0.05:
        print('该序列不是平稳的时间序列')
    else:
        print('该序列是平稳的时间序列')
def adf(data):
    from statsmodels.tsa.stattools import adfuller
    res = adfuller(data)
    result_fromat = pd.Series(res[0:4], index=['Test Statistic', 'p-value', 'Lags Used', 'Number of Observations Used'])
    if result_fromat['p-value']>=0.05:
        return False
    else:
        return True
def ARIMA_model(data,n=7):#数据(一维)
    import warnings
    warnings.filterwarnings('ignore')
    try:
        classname=np.array(data.columns)[0]
        from statsmodels.api import tsa
        y = np.array(data)
        x = np.arange(len(y))
        plt.figure(figsize=(10, 6))
        plt.xlabel('time')
        plt.ylabel(classname)
        plt.plot(x, y)
        f = plt.gcf()
        file_exist(r'D:\res_photo\ARIMA_原数据.png')
        f.savefig(r'D:\res_photo\ARIMA_原数据.png')
        f.clear()
        i = 0
        # 若不平稳则进行差分或比值法
        if not adf(y):
            # print(dta)
            temp = np.zeros(len(y) - 1)
            for i in range((len(temp))):
                temp[i] = y[i + 1] - y[i]
                # temp[i]=(dta[i+1]-dta[i])/dta[i+1]
            i = 1
            while True:
                if adf(temp):
                    break
                if len(temp) == 1:
                    print('false')
                    break
                diff = np.zeros(len(temp) - 1)
                for j in range(len(diff)):
                    diff[j] = temp[j + 1] - temp[j]
                    # diff[j]=(temp[j+1]-temp[j])/temp[j+1]
                temp = diff.copy()
                i += 1
        # print(i)
        diff = temp.copy()
        # 自相关和偏相关图
        from statsmodels.tsa.stattools import acf, pacf
        from statsmodels.graphics.tsaplots import plot_acf, plot_pacf
        lag_acf = acf(y)  # nlags为自相关系数的最大滞后期数,nlags=20
        lag_pacf = pacf(y, method='ols')
        plt.figure(figsize=(10, 6))
        plot_acf(x)  # lags=20
        f = plt.gcf()
        file_exist(r'D:\res_photo\ARIMA_自相关图.png')
        f.savefig(r'D:\res_photo\ARIMA_自相关图.png')
        f.clear()
        plt.figure(figsize=(10, 6))
        plot_pacf(x)
        f = plt.gcf()
        file_exist(r'D:\res_photo\ARIMA_偏自相关图.png')
        f.savefig(r'D:\res_photo\ARIMA_偏自相关图.png')
        f.clear()
        # AIC定阶
        cat = tsa.arma_order_select_ic(y, max_ar=6, max_ma=4, ic='aic')['aic_min_order']  # AIC定阶
        md = tsa.ARIMA(y, order=(cat[0], i, cat[1])).fit()
        yhat = md.predict()
        err = np.sqrt(((y - yhat) ** 2).mean())
        y = y[1:]
        yhat = yhat[1:]
        x = x[1:]
        # 画图比较
        plt.figure(figsize=(10, 6))
        plt.xlabel('time')
        plt.ylabel(classname)
        plt.plot(x, y, 'r-', x, yhat, 'b-')
        plt.legend(('real data', 'predict data'))
        f = plt.gcf()
        file_exist(r'D:\res_photo\ARIMA_比较图.png')
        f.savefig(r'D:\res_photo\ARIMA_比较图.png')
        f.clear()
        # 残差分析
        residuals = pd.DataFrame(md.resid)
        plt.figure(figsize=(10, 6))
        residuals.plot(title="residuals")
        f = plt.gcf()
        file_exist(r'D:\res_photo\ARIMA_残差图.png')
        f.savefig(r'D:\res_photo\ARIMA_残差图.png')
        f.clear()
        plt.figure(figsize=(10, 6))
        residuals.plot(kind='kde', title="density")
        f = plt.gcf()
        file_exist(r'D:\res_photo\ARIMA_残差密度图.png')
        f.savefig(r'D:\res_photo\ARIMA_残差密度图.png')
        f.clear()
        # 预测值
        x_predict = np.arange(len(y)+1,len(y)+n+1)
        dnext = md.predict(len(y)+1,len(y)+n)
        plt.figure(figsize=(10, 6))
        plt.plot(x_predict, dnext)
        plt.xlabel('time')
        plt.ylabel(classname)
        f=plt.gcf()
        file_exist(r'D:\res_photo\ARIMA_预测图.png')
        f.savefig(r'D:\res_photo\ARIMA_预测图.png')
        f.clear()
        print('ARIMA模型(Autoregressive Integrated Moving Average model)，差分整合移动平均自回归模型，又称整合移动平均自回归模型，是时间序列预测分析方法之一。')
        print('详细结果:')
        print('预测值:')
        for i in range(len(dnext)):
            print(dnext[i],',',end='')
        print('误差标准差:',err)
        return [err,dnext]#误差标准差和预测值
    except Exception as e:
        print(e)
def BP_Neural_Network(x,y,x_pre=pd.DataFrame([])):#x可多维,y一维
    from sklearn.neural_network import MLPRegressor
    name=y.columns[0]
    x=np.array(x)
    y=np.array(y)
    m1=x.max(axis=0)
    m2=x.min(axis=0)
    bx=2*(x-m2)/(m1-m2)-1#数据标准化
    md=MLPRegressor(solver='lbfgs',activation='identity').fit(bx,y)
    if(x_pre.empty):
        y_h=[]
    else:
        bx_pre = np.array(x_pre)
        bx_pre = 2 * (bx_pre - m2) / (m1 - m2) - 1
        y_h =md.predict(bx_pre)
    y_h0=md.predict(bx)
    delta=abs(y_h0-y)/y*100#相对误差
    plt.rc('font',size=14)
    plt.figure(figsize=(10, 6))
    time=range(1,len(y)+1)
    plt.plot(time,y,'--o',label='原始数据')
    plt.plot(time,y_h0,'-*',label='预测数据')
    if(len(time)<16):
        plt.xticks(time,rotation=55)#旋转
    plt.xlabel('period')
    plt.ylabel('{}'.format(name))
    plt.legend()
    f = plt.gcf()
    file_exist(r'D:\res_photo\BP_Neural_Network.png')
    plt.savefig(r'D:\res_photo\BP_Neural_Network.png')
    f.clear()
    print('BP神经网络是一种按误差逆传播算法训练的多层前馈网络。')
    print('详细结果:')
    if(len(y_h)!=0):
        print('预测值')
        for i in range(len(y_h)):
            print(y_h[i],',',end='')
    print('残差方差:',delta.std(ddof=1))
    print('R-Square:',md.score(bx,y))
    return [delta.std(ddof=1),y_h]#残差方差与预测值

if __name__ == '__main__':
    argv = np.array(sys.argv)
    data=get_data(argv[1])
    algorithm=argv[2]
    #单参数
    if(sum(argv=='#')==1):#pca和adf
        column=argv[3:-1]
        b = Counter(column)
        for i in b.keys():
            if (b[i] % 2 == 0):
                column = column[column != i]
        column = np.unique(column)
        if(algorithm=='  主成分分析法'):
            PCA_func(data[column])
        elif(algorithm=='  单位根检验(ADF)'):
            ADF(data[column])
        elif(algorithm=='  移动平均法'):
            MoveAverage(data[column])
        elif(algorithm=='  指数平滑法'):
            expmove(data[column])
        elif(algorithm=='  ARIMA模型'):
            ARIMA_model(data[column])
    # 两参数
    elif(sum(argv=='#')==2):
        ind1 = find(argv, 3)
        arg1=argv[3:ind1]
        arg2=argv[ind1+1:-1]#最后一个是'#'
        b1 = Counter(arg1)
        for i in b1.keys():
            if (b1[i] % 2 == 0):
                arg1 = arg1[arg1 != i]
        arg1 = np.unique(arg1)
        b2 = Counter(arg2)
        for i in b2.keys():
            if (b2[i] % 2 == 0):
                arg2 = arg2[arg2 != i]
        arg2 = np.unique(arg2)
        if(algorithm=='  灰色预测模型'):
            gray_model_GM11(data[arg1],data[arg1].columns[0],int(arg2))
        if(algorithm=='  多项式回归' or algorithm=='  线性回归'):
            po(data[arg1],data[arg2])
        elif(algorithm=='  岭回归'):
            ridge_regression(data[arg1],data[arg2])
        elif(algorithm=='  指数回归'):
            exp_regression(data[arg1],data[arg2])
        elif(algorithm=='  偏最小二乘回归'):
            LSRegression(data[arg1],data[arg2])
        elif(algorithm=='  CRITIC定权'):
            if (arg1 == []):
                column = arg2
            elif (arg2 ==[]):
                column = arg1
            else:
                column = np.hstack((arg1, arg2))
            CRITIC(data[column],arg1,arg2)
        elif(algorithm=='  熵值法'):
            if (arg1==[]):
                column = arg2
            elif (arg2==[]):
                column = arg1
            else:
                column = np.hstack((arg1, arg2))
            entropy_weight(data[column], arg1, arg2)
        elif(algorithm=='  优劣解距离法'):
            if (arg1 == []):
                column = arg2
            elif (arg2 == []):
                column = arg1
            else:
                column = np.hstack((arg1, arg2))
            TOPSIS(data[column], arg1, arg2)
        if (algorithm == '  决策树分类' or algorithm=='  逻辑回归' or algorithm=='  adaboost分类' or
        algorithm=='  随机森林分类' or algorithm=='  K近邻(KNN)分类'):
            machine(data[arg1], data[arg2])
        if (algorithm == '  BP-神经网络'):
            BP_Neural_Network(data[arg1], data[arg2])
# df=pd.read_excel("D:\\pythonProject1\\公路客运量_BP预测.xlsx")
# args=np.array(['人口','人口','客运量','客运量','客运量','人口','年份','年份','年份','年份'])
# b=Counter(args)
# for i in b.keys():
#     if(b[i]%2==0):
#         args=args[args!=i]
# a=np.array(set(args))
#
# x=df[a]
# # print(x)
# # y=df[['客运量']]
# # time=df[['年份']]
# # BP_Neural_Network(x,y,time)
# print(x)


# a=np.array([1,2,3,4,5,4,3,1,1])
# b=Counter(a)
# # print(b.keys())
# for i in b.keys():
#     if(b[i]%2==0):
#         a=a[a!=i]
# a=np.array(set(a))
# print(a)

